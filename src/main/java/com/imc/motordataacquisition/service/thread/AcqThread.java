package com.imc.motordataacquisition.service.thread;

import com.imc.motordataacquisition.properties.UdpProperties;
import com.imc.motordataacquisition.service.udp.UdpServer;
import net.openhft.affinity.AffinityLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * 数据采集线程
 */
public class AcqThread extends Thread {
    public volatile boolean running = false;
    //创建缓冲区的线程
    BufCreatedThread bufCreatedThread = new BufCreatedThread();
    //udp服务器
    UdpServer server;
    //记录已经接收到的个数
    int count = 0;
    //用于存储excel的线程池
    ExecutorService executorService = Executors.newCachedThreadPool();

    public AcqThread(UdpServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        //开启创建缓冲区的线程
        bufCreatedThread.start();
        //将此线程绑定在11号CPU上面
        try (AffinityLock affinityLock = AffinityLock.acquireLock(11)) {
            //设置此线程优先级为最高
            this.setPriority(MAX_PRIORITY);
            //如果线程被中断，就退出
            while (!isInterrupted()) {
                //如果有停止信号，就阻塞在这里
                if (!running) {
                    LockSupport.park();
                }
                //开始接收，将数据缓存到server的buf中
                server.recv(count++);
                //当接收到0.75个缓存长度之后，就提前创建下一个缓存区
                if (count == 0.75 * UdpProperties.RATE) {
                    //这里通知BufCreatedThread进行创建，使用LockSupport
                    LockSupport.unpark(bufCreatedThread);
                }
                if (count == UdpProperties.RATE) {
                    //将存excel任务交给线程池
                    executorService.submit(new ExcelSavingTask(server.getCurrData()));
                    //重新设置count和server内部的缓冲区
                    count = 0;
                    server.setCurrData(bufCreatedThread.getNewBuf());
                }
            }
        }
        //通知停止用于创建Buf的线程
        bufCreatedThread.interrupt();
        //关闭线程池
        executorService.shutdown();
    }
}

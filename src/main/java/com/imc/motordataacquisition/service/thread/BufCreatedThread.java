package com.imc.motordataacquisition.service.thread;

import com.imc.motordataacquisition.properties.UdpProperties;
import lombok.Getter;
import net.openhft.affinity.AffinityLock;

import java.util.concurrent.locks.LockSupport;

/**
 * 专门起一个线程用来创建缓冲区
 */
public class BufCreatedThread extends Thread{
    @Getter
    private byte[][] newBuf;

    @Override
    public void run() {
        try (AffinityLock affinityLock = AffinityLock.acquireLock(10)) {
            while (!isInterrupted()) {
                //等待通知
                LockSupport.park();
                newBuf = new byte[UdpProperties.RATE][64];
            }
        }
    }
}

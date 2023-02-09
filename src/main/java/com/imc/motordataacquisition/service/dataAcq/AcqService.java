package com.imc.motordataacquisition.service.dataAcq;

import com.imc.motordataacquisition.service.thread.AcqThread;
import com.imc.motordataacquisition.service.udp.UdpServer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.LockSupport;

@Service
public class AcqService implements InitializingBean {
    @Autowired
    private UdpServer server;

    AcqThread acqThread;

    /**
     * 开始采集数据
     */
    public void startAcq() {
        acqThread.running = true;
        LockSupport.unpark(acqThread);
    }

    /**
     * 停止采集数据
     */
    public void stopAcq() {
        acqThread.running = false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        acqThread = new AcqThread(server);
        acqThread.start();
    }
}

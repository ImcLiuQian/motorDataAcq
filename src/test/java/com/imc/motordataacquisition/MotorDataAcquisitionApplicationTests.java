package com.imc.motordataacquisition;

import com.imc.motordataacquisition.properties.UdpProperties;
import com.imc.motordataacquisition.service.thread.ExcelSavingTask;
import net.openhft.affinity.AffinityLock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.LockSupport;

@SpringBootTest
class MotorDataAcquisitionApplicationTests {

    @Test
    void contextLoads() {
        try (AffinityLock affinityLock = AffinityLock.acquireLock(11)) {
            while (true) {}
        }
    }

}

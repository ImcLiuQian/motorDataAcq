package com.imc.motordataacquisition;

import net.openhft.affinity.AffinityLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotorDataAcquisitionApplication {

    public static void main(String[] args) {
        //绑定在11号CPU上
        try (AffinityLock affinityLock = AffinityLock.acquireLock(11)) {
            SpringApplication.run(MotorDataAcquisitionApplication.class, args);
        }
    }
}

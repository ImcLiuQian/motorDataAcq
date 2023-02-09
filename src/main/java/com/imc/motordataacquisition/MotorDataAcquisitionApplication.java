package com.imc.motordataacquisition;

import net.openhft.affinity.AffinityLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotorDataAcquisitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorDataAcquisitionApplication.class, args);
    }
}

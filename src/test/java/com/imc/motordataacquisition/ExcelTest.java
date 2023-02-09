package com.imc.motordataacquisition;

import com.imc.motordataacquisition.entity.Motor;
import com.imc.motordataacquisition.service.dataSave.MotorExcel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ExcelTest {
    @Test
    void save() {
        Motor motor1 = new Motor();
        Motor motor2 = new Motor();
        List<Motor> motors = Arrays.asList(motor1, motor2);
//        MotorExcel.saveList();
    }
}

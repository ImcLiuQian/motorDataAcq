package com.imc.motordataacquisition.service.thread;

import com.imc.motordataacquisition.entity.Motor;
import com.imc.motordataacquisition.service.dataSave.MotorExcel;
import com.imc.motordataacquisition.properties.FileProperties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelSavingTask implements Runnable {
    List<Motor> motors = null;

    public ExcelSavingTask(byte[][] currData) {
        this.motors = Motor.createListByByteList(currData);
    }

    @Override
    public void run() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName =  formatter.format(new Date()) + ".xls";
        String excelPath = FileProperties.DIR_PATH + fileName;
        MotorExcel.saveList(excelPath, motors);
    }
}

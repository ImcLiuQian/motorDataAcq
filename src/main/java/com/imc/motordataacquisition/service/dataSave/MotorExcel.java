package com.imc.motordataacquisition.service.dataSave;

import com.imc.motordataacquisition.entity.Motor;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MotorExcel {

    public static void saveList(String fileName, List<Motor> motors) {
        try {
            String[] title = new String[]{"statusCode", "controlCode", "modeCode", "errorCode",
                    "referenceMechanicalPosition", "actualMechanicalPosition", "referenceMechanicalSpeed", "actualMechanicalSpeed",
                    "referenceCurrentId", "actualCurrentId", "referenceCurrentIq", "actualCurrentIq",
                    "uCurrent", "vCurrent", "voltageVd", "voltageVq",
                    "positionRingKp", "positionRingKd", "speedRingKp", "speedRingKi",
                    "currentRingKp", "currentRingKi", "extandData1", "extandData2",
                    "extandData3", "extandData4", "extandData5", "extandData6",
                    "extandData7", "extandData8"};

            File excelFile = new File(fileName);
            excelFile.createNewFile();
            WritableWorkbook workbook = Workbook.createWorkbook(excelFile);
            WritableSheet testSheet = workbook.createSheet("motor", 0);

            Label label = null;

            for (int j = 0; j < title.length; j++) {
                label = new Label(j, 0, title[j]);
                testSheet.addCell(label);
            }

            int count = 0;

            for (Motor motor : motors) {
                count++;
                label = new Label(0, count, motor.getStatusCode().toString());
                testSheet.addCell(label);
                label = new Label(1, count, motor.getControlCode().toString());
                testSheet.addCell(label);
                label = new Label(2, count, motor.getModeCode().toString());
                testSheet.addCell(label);
                label = new Label(3, count, motor.getErrorCode().toString());
                testSheet.addCell(label);
                label = new Label(4, count, motor.getReferenceMechanicalPosition().toString());
                testSheet.addCell(label);
                label = new Label(5, count, motor.getActualMechanicalPosition().toString());
                testSheet.addCell(label);
                label = new Label(6, count, motor.getReferenceMechanicalSpeed().toString());
                testSheet.addCell(label);
                label = new Label(7, count, motor.getActualMechanicalSpeed().toString());
                testSheet.addCell(label);
                label = new Label(8, count, motor.getReferenceCurrentId().toString());
                testSheet.addCell(label);
                label = new Label(9, count, motor.getActualCurrentId().toString());
                testSheet.addCell(label);
                label = new Label(10, count, motor.getReferenceCurrentIq().toString());
                testSheet.addCell(label);
                label = new Label(11, count, motor.getActualCurrentIq().toString());
                testSheet.addCell(label);
                label = new Label(12, count, motor.getUCurrent().toString());
                testSheet.addCell(label);
                label = new Label(13, count, motor.getVCurrent().toString());
                testSheet.addCell(label);
                label = new Label(14, count, motor.getVoltageVd().toString());
                testSheet.addCell(label);
                label = new Label(15, count, motor.getVoltageVq().toString());
                testSheet.addCell(label);
                label = new Label(16, count, motor.getPositionRingKp().toString());
                testSheet.addCell(label);
                label = new Label(17, count, motor.getPositionRingKd().toString());
                testSheet.addCell(label);
                label = new Label(18, count, motor.getSpeedRingKp().toString());
                testSheet.addCell(label);
                label = new Label(19, count, motor.getSpeedRingKi().toString());
                testSheet.addCell(label);
                label = new Label(20, count, motor.getCurrentRingKp().toString());
                testSheet.addCell(label);
                label = new Label(21, count, motor.getCurrentRingKi().toString());
                testSheet.addCell(label);
                label = new Label(22, count, motor.getExtandData1().toString());
                testSheet.addCell(label);
                label = new Label(23, count, motor.getExtandData2().toString());
                testSheet.addCell(label);
                label = new Label(24, count, motor.getExtandData3().toString());
                testSheet.addCell(label);
                label = new Label(25, count, motor.getExtandData4().toString());
                testSheet.addCell(label);
                label = new Label(26, count, motor.getExtandData5().toString());
                testSheet.addCell(label);
                label = new Label(27, count, motor.getExtandData6().toString());
                testSheet.addCell(label);
                label = new Label(28, count, motor.getExtandData7().toString());
                testSheet.addCell(label);
                label = new Label(29, count, motor.getExtandData8().toString());
                testSheet.addCell(label);
            }

            workbook.write();
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (WriteException e) {
            throw new RuntimeException(e);
        }
    }
}

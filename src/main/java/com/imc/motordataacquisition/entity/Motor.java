package com.imc.motordataacquisition.entity;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 电机数据结构
 */
@Data
@ToString
public class Motor {
    private Short statusCode;
    private Short controlCode;
    private Short modeCode;
    private Short errorCode;

    private Short referenceMechanicalPosition;
    private Short actualMechanicalPosition;
    private Short referenceMechanicalSpeed;
    private Short actualMechanicalSpeed;

    private Short referenceCurrentId;
    private Short actualCurrentId;
    private Short referenceCurrentIq;
    private Short actualCurrentIq;

    private Short uCurrent;
    private Short vCurrent;

    private Short voltageVd;
    private Short voltageVq;
    private Short positionRingKp;
    private Short positionRingKd;
    private Short speedRingKp;
    private Short speedRingKi;
    private Short currentRingKp;
    private Short currentRingKi;

    private Short extandData1;
    private Short extandData2;
    private Short extandData3;
    private Short extandData4;
    private Short extandData5;
    private Short extandData6;
    private Short extandData7;
    private Short extandData8;

    public Motor() {}

    /**
     * 根据字节数组创建电机数据
     * @param data
     * @return
     */
    public static Motor createByBytes(byte[] data) {
        Motor motor = new Motor();

        motor.statusCode = ((short) (((data[2] & 0xFF) << 8) | (data[3] & 0xFF)));
        motor.controlCode = ((short) (((data[4] & 0xFF) << 8) | (data[5] & 0xFF)));
        motor.modeCode = ((short) (((data[6] & 0xFF) << 8) | (data[7] & 0xFF)));
        motor.errorCode = ((short) (((data[8] & 0xFF) << 8) | (data[9] & 0xFF)));

        motor.referenceMechanicalPosition = ((short) (((data[10] & 0xFF) << 8) | (data[11] & 0xFF)));
        motor.actualMechanicalPosition = ((short) (((data[12] & 0xFF) << 8) | (data[13] & 0xFF)));
        motor.referenceMechanicalSpeed = ((short) (((data[14] & 0xFF) << 8) | (data[15] & 0xFF)));
        motor.actualMechanicalSpeed = ((short) (((data[16] & 0xFF) << 8) | (data[17] & 0xFF)));

        motor.referenceCurrentId = ((short) (((data[18] & 0xFF) << 8) | (data[19] & 0xFF)));
        motor.actualCurrentId = ((short) (((data[20] & 0xFF) << 8) | (data[21] & 0xFF)));
        motor.referenceCurrentIq = ((short) (((data[22] & 0xFF) << 8) | (data[23] & 0xFF)));
        motor.actualCurrentIq = ((short) (((data[24] & 0xFF) << 8) | (data[25] & 0xFF)));

        motor.uCurrent = ((short) (((data[26] & 0xFF) << 8) | (data[27] & 0xFF)));
        motor.vCurrent = ((short) (((data[28] & 0xFF) << 8) | (data[29] & 0xFF)));

        motor.voltageVd = ((short) (((data[30] & 0xFF) << 8) | (data[31] & 0xFF)));
        motor.voltageVq = ((short) (((data[32] & 0xFF) << 8) | (data[33] & 0xFF)));
        motor.positionRingKp = ((short) (((data[34] & 0xFF) << 8) | (data[35] & 0xFF)));
        motor.positionRingKd = ((short) (((data[36] & 0xFF) << 8) | (data[37] & 0xFF)));
        motor.speedRingKp = ((short) (((data[38] & 0xFF) << 8) | (data[39] & 0xFF)));
        motor.speedRingKi = ((short) (((data[40] & 0xFF) << 8) | (data[41] & 0xFF)));
        motor.currentRingKp = ((short) (((data[42] & 0xFF) << 8) | (data[43] & 0xFF)));
        motor.currentRingKi = ((short) (((data[44] & 0xFF) << 8) | (data[45] & 0xFF)));

        motor.extandData1 = ((short) (((data[46] & 0xFF) << 8) | (data[47] & 0xFF)));
        motor.extandData2 = ((short) (((data[48] & 0xFF) << 8) | (data[49] & 0xFF)));
        motor.extandData3 = ((short) (((data[50] & 0xFF) << 8) | (data[51] & 0xFF)));
        motor.extandData4 = ((short) (((data[52] & 0xFF) << 8) | (data[53] & 0xFF)));
        motor.extandData5 = ((short) (((data[54] & 0xFF) << 8) | (data[55] & 0xFF)));
        motor.extandData6 = ((short) (((data[56] & 0xFF) << 8) | (data[57] & 0xFF)));
        motor.extandData7 = ((short) (((data[58] & 0xFF) << 8) | (data[59] & 0xFF)));
        motor.extandData8 = ((short) (((data[60] & 0xFF) << 8) | (data[61] & 0xFF)));
        return motor;
    }

    /**
     * 根据二维字节数组创建电机数据集合
     * @param data
     * @return
     */
    public static List<Motor> createListByByteList(byte[][] data) {
        ArrayList<Motor> motors = new ArrayList<>(data.length);
        for (byte[] datum : data) {
            motors.add(Motor.createByBytes(datum));
        }
        return motors;
    }

    /**
     * 将电机数据转换为字节数组
     * @return
     */
    public byte[] getBytes() {
        byte[] bytes = new byte[64];
        bytes[0] = 0x33;
        bytes[1] = 0x33;

        bytes[2] = (byte) ((statusCode >> 8) & 0xff);
        bytes[3] = (byte) (statusCode & 0xff);
        bytes[4] = (byte) ((controlCode >> 8) & 0xff);
        bytes[5] = (byte) (controlCode & 0xff);
        bytes[6] = (byte) ((modeCode >> 8) & 0xff);
        bytes[7] = (byte) (modeCode & 0xff);
        bytes[8] = (byte) ((errorCode >> 8) & 0xff);
        bytes[9] = (byte) (errorCode & 0xff);

        bytes[10] = (byte) ((referenceMechanicalPosition >> 8) & 0xff);
        bytes[11] = (byte) (referenceMechanicalPosition & 0xff);
        bytes[12] = (byte) ((actualMechanicalPosition >> 8) & 0xff);
        bytes[13] = (byte) (actualMechanicalPosition & 0xff);
        bytes[14] = (byte) ((referenceMechanicalSpeed >> 8) & 0xff);
        bytes[15] = (byte) (referenceMechanicalSpeed & 0xff);
        bytes[16] = (byte) ((actualMechanicalSpeed >> 8) & 0xff);
        bytes[17] = (byte) (actualMechanicalSpeed & 0xff);

        bytes[18] = (byte) ((referenceCurrentId >> 8) & 0xff);
        bytes[19] = (byte) (referenceCurrentId & 0xff);
        bytes[20] = (byte) ((actualCurrentId >> 8) & 0xff);
        bytes[21] = (byte) (actualCurrentId & 0xff);
        bytes[22] = (byte) ((referenceCurrentIq >> 8) & 0xff);
        bytes[23] = (byte) (referenceCurrentIq & 0xff);
        bytes[24] = (byte) ((actualCurrentIq >> 8) & 0xff);
        bytes[25] = (byte) (actualCurrentIq & 0xff);

        bytes[26] = (byte) ((uCurrent >> 8) & 0xff);
        bytes[27] = (byte) (uCurrent & 0xff);
        bytes[28] = (byte) ((vCurrent >> 8) & 0xff);
        bytes[29] = (byte) (vCurrent & 0xff);

        bytes[30] = (byte) ((voltageVd >> 8) & 0xff);
        bytes[31] = (byte) (voltageVd & 0xff);
        bytes[32] = (byte) ((voltageVq >> 8) & 0xff);
        bytes[33] = (byte) (voltageVq & 0xff);
        bytes[34] = (byte) ((positionRingKp >> 8) & 0xff);
        bytes[35] = (byte) (positionRingKp & 0xff);
        bytes[36] = (byte) ((positionRingKd >> 8) & 0xff);
        bytes[37] = (byte) (positionRingKd & 0xff);
        bytes[38] = (byte) ((speedRingKp >> 8) & 0xff);
        bytes[39] = (byte) (speedRingKp & 0xff);
        bytes[40] = (byte) ((speedRingKi >> 8) & 0xff);
        bytes[41] = (byte) (speedRingKi & 0xff);
        bytes[42] = (byte) ((currentRingKp >> 8) & 0xff);
        bytes[43] = (byte) (currentRingKp & 0xff);
        bytes[44] = (byte) ((currentRingKi >> 8) & 0xff);
        bytes[45] = (byte) (currentRingKi & 0xff);


        bytes[46] = (byte) ((extandData1 >> 8) & 0xff);
        bytes[47] = (byte) (extandData1 & 0xff);
        bytes[48] = (byte) ((extandData2 >> 8) & 0xff);
        bytes[49] = (byte) (extandData2 & 0xff);
        bytes[50] = (byte) ((extandData3 >> 8) & 0xff);
        bytes[51] = (byte) (extandData3 & 0xff);
        bytes[52] = (byte) ((extandData4 >> 8) & 0xff);
        bytes[53] = (byte) (extandData4 & 0xff);
        bytes[54] = (byte) ((extandData5 >> 8) & 0xff);
        bytes[55] = (byte) (extandData5 & 0xff);
        bytes[56] = (byte) ((extandData6 >> 8) & 0xff);
        bytes[57] = (byte) (extandData6 & 0xff);
        bytes[58] = (byte) ((extandData7 >> 8) & 0xff);
        bytes[59] = (byte) (extandData7 & 0xff);
        bytes[60] = (byte) ((extandData8 >> 8) & 0xff);
        bytes[61] = (byte) (extandData8 & 0xff);

        bytes[62] = 0x55;
        bytes[63] = 0x55;

        return bytes;
    }
}

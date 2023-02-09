package com.imc.motordataacquisition.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 文件配置
 */
@Component
public class FileProperties implements InitializingBean {
    @Value("${motorData.filePath:\"/home\"}")
    private String filePath;

    public static String DIR_PATH;

    @Override
    public void afterPropertiesSet() throws Exception {
        //创建用于存放数据的文件夹
        String motorDirsPath = filePath + "/motor_data";
        File motorDirs = new File(motorDirsPath);
        if (!motorDirs.exists()) {
            motorDirs.mkdirs();
        }
        //记录文件位置
        DIR_PATH = motorDirsPath + "/";
    }
}

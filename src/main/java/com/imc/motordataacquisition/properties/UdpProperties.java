package com.imc.motordataacquisition.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("UdpProperties")
public class UdpProperties implements InitializingBean {
    @Value("${motorData.rate:10000}")
    private Integer rate;

    public static Integer RATE;

    @Override
    public void afterPropertiesSet() throws Exception {
        RATE = rate;
    }
}

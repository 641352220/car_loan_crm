package com.bootdo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="aliyun.oss")
public class AliyunOSS {

    private String cdn;

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    public String getCdn() {
        return cdn;
    }
}

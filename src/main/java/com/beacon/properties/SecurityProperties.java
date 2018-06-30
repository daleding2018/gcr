package com.beacon.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "beacon.security")//配置文件读取器，管理以my.security开头的配置信息
public class SecurityProperties {

    private Oauth2Properties oauth2 = new Oauth2Properties();

    public Oauth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(Oauth2Properties oauth2) {
        this.oauth2 = oauth2;
    }

    @Override
    public String toString() {
        return "SecurityProperties{" +
                "oauth2=" + oauth2 +
                '}';
    }
}

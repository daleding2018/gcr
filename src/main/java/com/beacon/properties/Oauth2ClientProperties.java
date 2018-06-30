package com.beacon.properties;

public class Oauth2ClientProperties {

    private String clientId;

    private String clientSecret;

    /**设置token有效时间*/
    private int accessTokenValiditySeconds = 1800;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public int getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }


    @Override
    public String toString() {
        return "Oauth2ClientProperties{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", accessTokenValiditySeconds=" + accessTokenValiditySeconds +
                '}';
    }
}

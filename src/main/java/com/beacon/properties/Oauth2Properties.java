package com.beacon.properties;

public class Oauth2Properties {

    private  Oauth2ClientProperties clients = new Oauth2ClientProperties();

    public Oauth2ClientProperties getClients() {
        return clients;
    }

    public void setClients(Oauth2ClientProperties clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Oauth2Properties{" +
                "clients=" + clients +
                '}';
    }
}

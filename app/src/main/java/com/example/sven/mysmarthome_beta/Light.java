package com.example.sven.mysmarthome_beta;

/**
 * Created by Sven on 29.04.2016.
 */
public class Light implements Consumer {

    private boolean lightPower;

    public Light(boolean lightPower) {
        this.lightPower = lightPower;
    }

    public boolean isLightPower() {
        return lightPower;
    }

    public void setLightPower(boolean lightPower) {
        this.lightPower = lightPower;
    }
}

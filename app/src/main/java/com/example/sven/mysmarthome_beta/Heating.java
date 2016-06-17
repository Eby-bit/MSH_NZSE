package com.example.sven.mysmarthome_beta;

/**
 * Created by Sven on 29.04.2016.
 */
public class Heating implements Consumer {

    private Integer off=new Integer(0);
    private Integer minTemp=new Integer(14);
    private Integer maxTemp=new Integer(25);

    public Integer getOff() {
        return off;
    }

    public Integer getMinTemp() {
        return minTemp;
    }

    public Integer getMaxTemp() {
        return maxTemp;
    }
}

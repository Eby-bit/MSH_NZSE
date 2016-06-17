package com.example.sven.mysmarthome_beta;

/**
 * Created by Sven on 29.04.2016.
 */
public class Fridge implements Consumer{
    private boolean fridgePower;

    public Fridge(boolean fridgePower) {
        this.fridgePower = fridgePower;
    }

    public boolean isFridgePower() {
        return fridgePower;
    }

    public void setFridgePower(boolean fridgePower) {
        this.fridgePower = fridgePower;
    }
}

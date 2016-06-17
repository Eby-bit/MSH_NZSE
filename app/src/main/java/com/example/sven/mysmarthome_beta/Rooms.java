package com.example.sven.mysmarthome_beta;


/**
 * Created by Sven on 29.04.2016.
 */
import java.util.ArrayList;

enum Roomtype{
    LIVINGROOM, KITCHEN, GARAGE, BATHROOM
}

public class Rooms {
    private Roomtype roomName;
    public void addConsumer() {

    }
    public void delConsumer(){

    }
    public static ArrayList<Consumer> consumer = new ArrayList<Consumer>();
    public Rooms(Roomtype roomName){
        super();
        this.roomName = roomName;
    }
}

package com.liyi.sensordata;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class Activity {
    private String time;
    private String air;
    private String ground;
    private String distance;
    private String date;
    private String pressure;

    public Activity(String time,String air,String ground,String distance,String date,String pressure){
        this.time = time;
        this.air = air;
        this.ground = ground;
        this.distance = distance;
        this.date = date;
        this.pressure =pressure;
    }
    public String getTime(){ return time;}
    public String getAir(){ return air;}
    public String getGround(){ return ground;}
    public String getDistance(){return distance;}
    public String getDate(){return date;}
    public String getPressure(){return pressure;}


}


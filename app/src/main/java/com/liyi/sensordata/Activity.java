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

<<<<<<< HEAD

    public Activity(String activity_id,String start_time,String end_time,String distance,String date,String pressure){
        this.activity_id = activity_id;
        this.start_time = start_time;
        this.end_time = end_time;
=======
    public Activity(String time,String air,String ground,String distance,String date,String pressure){
        this.time = time;
        this.air = air;
        this.ground = ground;
>>>>>>> 5fd0730eaf30d426c5d68e204e58f322ede407db
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


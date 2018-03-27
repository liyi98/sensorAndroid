package com.liyi.sensordata;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * Created by liyi on 3/22/2018.
 */

public class Activity {
    private String activity_id;
    private String start_time;
    private String end_time;
    private String distance;
    private String date;
    private String pressure;

    public Activity(){}
    public Activity(String activity_id,String start_time,String end_time,String distance,String date,String pressure){
        this.activity_id = activity_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.distance = distance;
        this.date = date;
        this.pressure =pressure;
    }
    public String getActivity_id(){
        return  activity_id;
    }
    public String getStart_time(){
        return start_time;
    }
    public String getEnd_time(){
        return end_time;
    }
    public String getDistance(){return distance;}
    public String getDate(){return date;}
    public String getPressure(){return pressure;}
    @Override
    public String toString() {
        return activity_id;
    }








}


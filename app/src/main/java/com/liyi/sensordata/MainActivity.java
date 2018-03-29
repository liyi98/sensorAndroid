package com.liyi.sensordata;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.liyi.sensordata.adapter.ActivityAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mlist;
    private ArrayList<Activity> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlist = (ListView) findViewById(R.id.listView);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        list = new ArrayList<Activity>();
        String url = "http://khaibin.asuscomm.com/sensor/main.php?view=get_activity";


        JsonArrayRequest jsonRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // the response is already constructed as a JSONObject!
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject temp = response.getJSONObject(i);
                                String start = temp.getString("start_time");
                                String end = temp.getString("end_time");
                                double time = Double.parseDouble(end) - Double.parseDouble(start);
                                String air = temp.getString("average_time_on_air");
                                String ground = temp.getString("average_time_on_ground");
                                String distance = temp.getString("distance");
                                String date = temp.getString("created_at");
                                String pressure = temp.getString("average_pressure");

                                list.add(new Activity("time: " +Double.toString(time) + "s","avg_on_air: "+ air, "avg_on_ground: " + ground,"distance: "+ distance +"km","date: "+ date,"pressure: "+ pressure+"Pa"));

                            }
                            ActivityAdapter adapter = new ActivityAdapter(MainActivity.this, list);
                            mlist.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        Volley.newRequestQueue(this).add(jsonRequest);

    }




}

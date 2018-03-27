package com.liyi.sensordata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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
import com.liyi.sensordata.http.CustomRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mtext;
    private ImageButton mButton;
    private ListView mlist;
   private ArrayList<Activity> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (ImageButton) findViewById(R.id.imageButton3);
        mTextMessage = (TextView) findViewById(R.id.textView5);
        mtext = (TextView) findViewById(R.id.textView6);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextMessage.setText("Hello Li Yi");
            }
        });
        mlist = (ListView) findViewById(R.id.listView);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        list = new ArrayList<Activity>();
        String url = "http://khaibin.asuscomm.com/liyi.json";


        JsonArrayRequest jsonRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // the response is already constructed as a JSONObject!
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject temp = response.getJSONObject(i);
                                String activity_id = temp.getString("activity_id");
                                String start_time = temp.getString("start_time");
                                String end_time = temp.getString("end_time");
                                String distance = temp.getString("distance");
                                String date = temp.getString("created_at");
                                String pressure = temp.getString("average_pressure");
                                mtext.setText(temp.getString("activity_id"));
                                list.add(new Activity(activity_id,start_time,end_time,distance+" m",date,pressure));

                            }

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
        ActivityAdapter adapter = new ActivityAdapter(MainActivity.this, list);
        mlist.setAdapter(adapter);








    }




}

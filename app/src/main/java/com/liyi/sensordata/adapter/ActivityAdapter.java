package com.liyi.sensordata.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyi.sensordata.Activity;
import com.liyi.sensordata.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by liyi on 3/22/2018.
 */

public class ActivityAdapter extends ArrayAdapter<Activity> {
        //int icons;
    public ActivityAdapter(Context context, List<Activity> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity currentActivity = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView view = (ImageView) convertView.findViewById(R.id.icon);
        view.setImageResource(R.drawable.foot);

        TextView text1 = (TextView) convertView.findViewById(R.id.text1);
        text1.setText(currentActivity.getActivity_id() + "");
        TextView text2 = (TextView) convertView.findViewById(R.id.text2);
        text2.setText(currentActivity.getStart_time() + "");
        TextView text3 = (TextView) convertView.findViewById(R.id.text3);
        text3.setText(currentActivity.getEnd_time() + "");
        TextView text4 = (TextView) convertView.findViewById(R.id.text4);
        text4.setText(currentActivity.getDistance() + "");
        TextView text5 = (TextView) convertView.findViewById(R.id.text5);
        text5.setText(currentActivity.getDate() + "");
        TextView text6 = (TextView) convertView.findViewById(R.id.text6);
        text6.setText(currentActivity.getPressure() + "");



        return convertView;
    }
}

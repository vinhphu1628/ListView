package com.example.win7.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by WIN7 on 13/03/2018.
 */

public class customAdapter extends ArrayAdapter<Integer> {

    private Context context;
    private int resoucre;
    private ArrayList<Integer> list;

    public customAdapter(Context context, int resoucre, ArrayList<Integer> list){
        super(context, resoucre, list);
        this.context = context;
        this.resoucre = resoucre;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(resoucre, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtMssv = convertView.findViewById(R.id.txt_mssv);
            viewHolder.txtTemperature = convertView.findViewById(R.id.txt_temperature);
            viewHolder.txtHumid = convertView.findViewById(R.id.txt_humid);
            viewHolder.txtTime = convertView.findViewById(R.id.txt_time);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        device device = list.get(position);
        viewHolder.txtMssv.setText(device.getMssv());
        viewHolder.txtTemperature.setText(String.valueOf(device.getTemperature()));
        viewHolder.txtHumid.setText(String.valueOf(device.getHumid()));
        viewHolder.txtTime.setText(String.valueOf(device.getTime()));

        return convertView;
    }

    public class ViewHolder{
        TextView txtMssv, txtTemperature, txtHumid, txtTime;
    }
}

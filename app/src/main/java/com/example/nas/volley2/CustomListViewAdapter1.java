package com.example.nas.volley2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NAS on 11/27/2015.
 */
public class CustomListViewAdapter1 extends ArrayAdapter<Rowitem> {
    Context context;
    List l;
    public CustomListViewAdapter1(Context context, int resourceid, List<Rowitem> item) {
        super(context,resourceid,item);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        Rowitem rowItem = getItem(position);
        LayoutInflater minflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.activity_list2, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.list_item11);
            holder.wifi_type = (TextView) convertView.findViewById(R.id.list_item12);
            holder.bssid = (TextView) convertView.findViewById(R.id.list_item13);
            holder.key = (TextView) convertView.findViewById(R.id.list_item14);
            holder.latitude = (TextView) convertView.findViewById(R.id.list_item15);
            holder.longitude = (TextView) convertView.findViewById(R.id.list_item16);



            holder.half = (TextView) convertView.findViewById(R.id.list_item17);
            holder.one = (TextView) convertView.findViewById(R.id.list_item18);
            holder.two = (TextView) convertView.findViewById(R.id.list_item19);
            holder.five = (TextView) convertView.findViewById(R.id.list_item20);
            holder.ten = (TextView) convertView.findViewById(R.id.list_item21);
            holder.twenty = (TextView) convertView.findViewById(R.id.list_item22);
            holder.twenty_four = (TextView) convertView.findViewById(R.id.list_item23);


            //holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.name.setText(rowItem.getName());
        holder.wifi_type.setText(""+rowItem.getWifi_type());

        holder.bssid.setText(""+rowItem.getBssid());
        holder.key.setText(""+rowItem.getKey());
        holder.latitude.setText(""+rowItem.getLatitude());
        holder.longitude.setText(""+rowItem.getLongitude());
        holder.half.setText(""+rowItem.getHalf());
        holder.one.setText(""+rowItem.getOne());

        holder.two.setText(""+rowItem.getTwo());
        holder.five.setText(""+rowItem.getFive());
        holder.ten.setText(""+rowItem.getTen());
        holder.twenty.setText(""+rowItem.getTwenty());
        holder.twenty_four.setText(""+rowItem.getTwenty_four()+"\n\n");



        // holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }


    private class ViewHolder {
        TextView name,wifi_type,bssid,key,latitude,longitude,half,one,two,five,ten,twenty,twenty_four;
    }


}



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
public class CustomListViewAdapter extends ArrayAdapter<Rowitem> {
    Context context;
    List l;
    public CustomListViewAdapter(Context context, int resourceid, List<Rowitem> item) {
        super(context,resourceid,item);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        Rowitem rowItem = getItem(position);
        LayoutInflater minflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.activity_list, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.list_item1);
            holder.wifi_type = (TextView) convertView.findViewById(R.id.list_item2);
            holder.bssid = (TextView) convertView.findViewById(R.id.list_item3);
            holder.key = (TextView) convertView.findViewById(R.id.list_item4);
            holder.latitude = (TextView) convertView.findViewById(R.id.list_item5);
            holder.longitude = (TextView) convertView.findViewById(R.id.list_item6);
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



        // holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }


    private class ViewHolder {
        TextView name,wifi_type,bssid,key,latitude,longitude;
    }


}



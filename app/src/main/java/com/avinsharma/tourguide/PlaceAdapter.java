package com.avinsharma.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Avin on 12-09-2016.
 */
public class PlaceAdapter extends ArrayAdapter<Place>{

    public PlaceAdapter (Context context, ArrayList<Place> objects){
        super(context,0,objects);
    }
    static class ViewHolder{
        ImageView photo;
        TextView name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            holder = new ViewHolder();
            holder.photo = (ImageView) convertView.findViewById(R.id.photo_image_view);
            holder.name = (TextView) convertView.findViewById(R.id.name_text_view);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Place currentPlace = getItem(position);

        Picasso.with(getContext()).load(currentPlace.getmImageviewResource()).fit().centerCrop().into(holder.photo);
        holder.name.setText(currentPlace.getmName());

        return convertView;
    }
}

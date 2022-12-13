package com.example.emptyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> pointList;
    Context context;

    public ListViewAdapter(Context context, int listLayout, int field,  ArrayList<JSONObject> pointList) {
        super(context, listLayout, field, pointList);
        this.listLayout = listLayout;
        this.pointList = pointList;
        this.context = context;
    }

    public View getView(int position, View converView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView latitude = listViewItem.findViewById(R.id.latitude);
        TextView longitude = listViewItem.findViewById(R.id.longitude);
        TextView name = listViewItem.findViewById(R.id.name);

        try{
            name.setText(pointList.get(position).getString("name"));
            latitude.setText(pointList.get(position).getString("latitude"));
            longitude.setText(pointList.get(position).getString("longitude"));


        }
        catch (JSONException je){
            je.printStackTrace();
        }
        return listViewItem;

    }





















}

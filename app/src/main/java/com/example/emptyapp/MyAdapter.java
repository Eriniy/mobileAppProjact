package com.example.emptyapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Point> arrayList;

   public MyAdapter(Context context, ArrayList<Point> arrayList){
        this.context = context;
        this.arrayList = arrayList;
   }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlistview, null);
        TextView t1_latitude = (TextView) convertView.findViewById(R.id.latitude_txt);
        TextView t2_longitude = (TextView) convertView.findViewById(R.id.longitude_txt);
        TextView t3_address = (TextView) convertView.findViewById(R.id.address_txt);

       Point point = arrayList.get(position);

       t1_latitude.setText(point.getLatitude());
       t2_longitude.setText(point.getLongitude());
       t3_address.setText(point.getAddress());

        return convertView;
    }
}
//

//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {
//
//    ArrayList<String> longitude;
//    ArrayList<String> latitude;
//
//    Context context;
//
//    public HelperAdapter(ArrayList<String> longitude, ArrayList<String> latitude, Context context) {
//        this.longitude = longitude;
//        this.latitude = latitude;
//        this.context = context;
//    }
//
//
//    @NonNull
//    @Override
//    public HelperAdapter.MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
//        MyViewClass myViewClass = new MyViewClass(view);
//        return myViewClass;
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewClass holder, int position){
//        holder.longitude.setText(longitude.get(position));
//        holder.latitude.setText(latitude.get(position));
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, "Item clicked", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//
//
//    public int getItemCount(){
//        return longitude.size();
//    }
//
//    public class MyViewClass extends RecyclerView.ViewHolder {
//        TextView longitude, latitude, id;
//
//        public MyViewClass(@NonNull View itemView){
//            super(itemView);
//            longitude = itemView.findViewById(R.id.longitude);
//            latitude = itemView.findViewById(R.id.latitude);
//        }
//    }
//}

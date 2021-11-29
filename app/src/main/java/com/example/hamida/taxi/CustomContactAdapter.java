package com.example.hamida.taxi;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class CustomContactAdapter extends RecyclerView.Adapter<CustomContactAdapter.MyViewHolder> {
    // declaring some fields.
    private ArrayList<ContactPOJO> arrayList;

    public CustomContactAdapter(ArrayList<ContactPOJO> arrayList) {
        this.arrayList = new ArrayList<>();
        this.arrayList = arrayList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView distance, time, course;
        public MyViewHolder(View itemView) {
            super(itemView);
            final int v = Log.v("ViewHolder", "in View Holder");
            distance = itemView.findViewById(R.id.tx_distance);
            time = itemView.findViewById(R.id.tx__time);
            course= itemView.findViewById(R.id.tx_course);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int   viewType) {
        Log.v("CreateViewHolder", "in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_layout,parent,false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int  position) {
        Log.v("BindViewHolder", "in onBindViewHolder");
        ContactPOJO contact = arrayList.get(position);
        holder.distance.setText(contact.getmDistance());
        holder.time.setText(contact.getmTime());
        holder.course.setText(contact.getmCourse());
    }

}

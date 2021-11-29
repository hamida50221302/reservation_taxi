package com.example.hamida.taxi;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class PassagerContactAdapter extends RecyclerView.Adapter<PassagerContactAdapter.MyViewHolder> {
    // declaring some fields.
    private ArrayList<ContactPassager> arrayList;

    public PassagerContactAdapter(ArrayList<ContactPassager> arrayList) {
        this.arrayList = new ArrayList<>();
        this.arrayList = arrayList;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView distance, time, distination,name;
        public MyViewHolder(View itemView) {
            super(itemView);
            final int v = Log.v("ViewHolder", "in View Holder");
            distance = itemView.findViewById(R.id.tx_distance);
            time = itemView.findViewById(R.id.tx__time);
            distination= itemView.findViewById(R.id.tx_distination);
            name=itemView.findViewById(R.id.tx_name);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int   viewType) {
        Log.v("CreateViewHolder", "in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_passager,parent,false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int  position) {
        Log.v("BindViewHolder", "in onBindViewHolder");
        ContactPassager contact = arrayList.get(position);
        holder.distance.setText(contact.getmDistance());
        holder.time.setText(contact.getmTime());
        holder.distination.setText(contact.getmDistination());
        holder.name.setText(contact.getmName());

    }

}

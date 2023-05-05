package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.MyViewHolder> {

    Context context;
    ArrayList<user2> list;

    public Myadapter2(Context context, ArrayList<user2> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

         user2 user2=list.get(position);
         holder.fullname.setText(user2.getFullname());
         holder.phoneno.setText(user2.getPhoneno());
         holder.address.setText(user2.getAddress());
         holder.city.setText(user2.getCity());
         holder.pincode.setText(user2.getPincode());
         holder.fees.setText(user2.getFees());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView  fullname,phoneno,address,city,pincode,fees;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname= itemView.findViewById(R.id.fullname1);
            phoneno=itemView.findViewById(R.id.PHONENO12);
            address=itemView.findViewById(R.id.ADDRESS12);
            city=itemView.findViewById(R.id.City12);
            pincode= itemView.findViewById(R.id.Pincode12);
            fees=itemView.findViewById(R.id.rent12);
        }
    }
}

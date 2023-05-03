package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter. MyViewHolder> {

    Context context;
    ArrayList<user> list;

    public Myadapter(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Myadapter. MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter. MyViewHolder holder, int position) {
      user user=list.get(position);
      holder.fullname.setText(user.getFullname());
      holder.phoneno.setText(user.getPhoneno());
      holder.address.setText(user.getAddress());
      holder.city.setText(user.getCity());
      holder.pincode.setText(user.getPincode());
      holder.pgfor.setText(user.getPgfor());
      holder.tiffinservice.setText(user.getTiffinservice());
      holder.rent.setText(user.getRent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullname,phoneno,address,city,pincode,pgfor,tiffinservice,rent;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname= itemView.findViewById(R.id.fullname1);
            phoneno=itemView.findViewById(R.id.PHONENO12);
            address=itemView.findViewById(R.id.ADDRESS12);
            city=itemView.findViewById(R.id.City12);
            pincode= itemView.findViewById(R.id.Pincode12);
            pgfor=itemView.findViewById(R.id.pgfor12);
            tiffinservice=itemView.findViewById(R.id.tiffinservice12);
            rent=itemView.findViewById(R.id.rent12);


        }
    }
}

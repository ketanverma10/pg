package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class search2 extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    Myadapter2 myadapter2;
    ArrayList<user2> list;
    Intent intent=getIntent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        recyclerView=findViewById(R.id.recyclerView2);
        database = FirebaseDatabase.getInstance().getReference("users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list= new ArrayList<>();
        myadapter2 = new Myadapter2(this, list);

        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String search_txt=intent.getStringExtra("search");



                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    user2 user2 = dataSnapshot.getValue(user2.class);
                    if(user2.getUsertype()==2 && user2.getCity().equals(search_txt.toUpperCase())) {
                        System.out.println("hello");



                        list.add(user2);
                    }



                }

                myadapter2.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myadapter2=new Myadapter2(this,list);
        recyclerView.setAdapter(myadapter2);




    }

    }

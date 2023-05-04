package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    TextView btn;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://pggg-fe0d3-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email=findViewById(R.id.inputUsername);
        final EditText password=findViewById(R.id.inputPassword);
        final Button logingbtn= findViewById(R.id.btnlogin);
        btn=findViewById(R.id.createAnAccount);

        logingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailtxt=email.getText().toString();
                final String passwordtxt= password.getText().toString();
                if(emailtxt.isEmpty()||passwordtxt.isEmpty()){
                    Toast.makeText(login.this, "please enter your mobile or password ", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(emailtxt)){
                                final String getpasswoed=snapshot.child(emailtxt).child("password").getValue(String.class);
                                final int ut=snapshot.child(emailtxt).child("usertype").getValue(Integer.class);
                                if(getpasswoed.equals(passwordtxt)){
                                    if(ut==0){
                                        String usern=emailtxt;
                                        int us=snapshot.child(emailtxt).child("usertype").getValue(Integer.class);
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        intent.putExtra("username",usern);
                                        intent.putExtra("utype",us);
                                        startActivity(intent);
                                        finish();

//                                        Toast.makeText(login.this, "successfully logged in", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(login.this, MainActivity.class));
                                    } else if (ut==1) {
                                        String usern=emailtxt;
                                        String name=snapshot.child(emailtxt).child("fullname").getValue(String.class);
                                        String phone=snapshot.child(emailtxt).child("phoneno").getValue(String.class);
                                        String r=snapshot.child(emailtxt).child("rent").getValue(String.class);
                                        String hno=snapshot.child(emailtxt).child("address").getValue(String.class);

                                        String c=snapshot.child(emailtxt).child("city").getValue(String.class);
                                        String f=snapshot.child(emailtxt).child("pg for").getValue(String.class);
                                        String pin=snapshot.child(emailtxt).child("pincode").getValue(String.class);
                                        Intent intent = new Intent(getApplicationContext(),home1.class);

                                        intent.putExtra("name",name);
                                        intent.putExtra("phoneno",phone);
                                        intent.putExtra("username",usern);
                                        intent.putExtra("address",hno);

                                        intent.putExtra("city",c);
                                        intent.putExtra("pincode",pin);
                                        intent.putExtra("pg for",f);
                                        intent.putExtra("rent",r);

                                        startActivity(intent);
                                        finish();




//                                        Toast.makeText(login.this, "successfully logged in", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(login.this, home1.class));
                                    } else if (ut==2) {
;
                                        String usern=emailtxt;
                                        String name=snapshot.child(emailtxt).child("fullname").getValue(String.class);
                                        String phone=snapshot.child(emailtxt).child("phoneno").getValue(String.class);
                                        String f=snapshot.child(emailtxt).child("fees").getValue(String.class);
                                        String hno=snapshot.child(emailtxt).child("addreess").getValue(String.class);

                                        String c=snapshot.child(emailtxt).child("city").getValue(String.class);
                                        String pin=snapshot.child(emailtxt).child("pincode").getValue(String.class);
                                        Intent intent = new Intent(getApplicationContext(),home2.class);

                                        intent.putExtra("name",name);
                                        intent.putExtra("phoneno",phone);
                                        intent.putExtra("username",usern);
                                        intent.putExtra("address",hno);

                                        intent.putExtra("city",c);
                                        intent.putExtra("pincode",pin);
                                        intent.putExtra("fees",f);
                                        startActivity(intent);
                                        finish();
                                        //                                        Toast.makeText(login.this, "successfully logged in", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(login.this, home2.class))
                                    }
                                }

                                else {
                                    Toast.makeText(login.this, "Wrong password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(login.this, "Wrong password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,register.class));
            }
        });
    }
}
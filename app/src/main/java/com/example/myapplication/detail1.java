package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class detail1 extends AppCompatActivity {

    TextView btn;
    Button registerButton;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pggg-fe0d3-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);

        final EditText fullname=  findViewById(R.id.FULLNAME);
        final EditText phoneno= findViewById(R.id.PHONENO);
        final EditText address= findViewById(R.id.ADDRESS);
        final EditText email = findViewById(R.id.inputEmail);
        final EditText password = findViewById(R.id.inputPassword);
        final EditText confpassword = findViewById(R.id.inputConfirmPassword);

        btn=findViewById(R.id.alreadyhaveAccount);
        registerButton = findViewById(R.id.btnRegister);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullnametxt=fullname.getText().toString();
                final String emailtxt=email.getText().toString();
                final String phonetxt=phoneno.getText().toString();
                final String passwordtxt=password.getText().toString();
                final String confpasswordtxt=confpassword.getText().toString();
                final String addresstxt=address.getText().toString();
                final int usertype=0;

                RadioButton rb = findViewById(R.id.radioButton);
                RadioButton rb1 = findViewById(R.id.radioButton2);
                RadioButton rb2= findViewById(R.id.radioButton3);

                if(fullnametxt.isEmpty()|| emailtxt.isEmpty()||phonetxt.isEmpty()||passwordtxt.isEmpty()){
                    Toast.makeText(detail1.this, "please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if (!passwordtxt.equals(confpasswordtxt)){
                    Toast.makeText(detail1.this, "Password are not matching ", Toast.LENGTH_SHORT).show();
                }
                else  if(phonetxt.length()!=10){
                    Toast.makeText(detail1.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(emailtxt)){
                                Toast.makeText(detail1.this, "Already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("users").child(emailtxt).child("fullname").setValue(fullnametxt);
                                databaseReference.child("users").child(emailtxt).child("address").setValue(addresstxt);
                                databaseReference.child("users").child(emailtxt).child("password").setValue(passwordtxt);
                                databaseReference.child("users").child(emailtxt).child("usertype").setValue(usertype);
                                databaseReference.child("users").child(emailtxt).child("phoneno").setValue(phonetxt);
                                if(rb.isChecked()){
                                    databaseReference.child("users").child(emailtxt).child("gender").setValue(rb.getText().toString());
                                } else if (rb1.isChecked()) {
                                    databaseReference.child("users").child(emailtxt).child("gender").setValue(rb1.getText().toString());

                                }
                                else {
                                    databaseReference.child("users").child(emailtxt).child("gender").setValue(rb2.getText().toString());
                                }

                                Toast.makeText(detail1.this, "USER REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(detail1.this,login.class));
                                finish();

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
                startActivity(new Intent(detail1.this,login.class));
            }
        });
    }
}
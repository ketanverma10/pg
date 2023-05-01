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

public class detail2 extends AppCompatActivity {

    TextView btn;
    Button registerButton;
    RadioGroup r;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pggg-fe0d3-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        final EditText fullname=  findViewById(R.id.FULLNAME);
        final EditText phoneno= findViewById(R.id.PHONENO);
        final EditText house= findViewById(R.id.houseno);
        final EditText village=findViewById(R.id.village);
        final EditText pincode=findViewById(R.id.Pincode);
        final EditText city=findViewById(R.id.City);
        final EditText email = findViewById(R.id.inputEmail);
        final EditText password = findViewById(R.id.inputPassword);
        final EditText confpassword = findViewById(R.id.inputConfirmPassword);
        final EditText landmark=findViewById(R.id.Landmark);
        final EditText rent = findViewById(R.id.rent);

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
                final String housetxt=house.getText().toString();
                final String citytext=city.getText().toString();
                final String villagetxt=village.getText().toString();
                final String pintxt=pincode.getText().toString();
                final String landmarktxt=landmark.getText().toString();
                final int usertype=1;
                final String rentxt=rent.getText().toString();
                RadioButton rb1=findViewById(R.id.yes);
                RadioButton rb2=findViewById(R.id.no);
                RadioButton rb3=findViewById(R.id.boys);
                RadioButton rb4=findViewById(R.id.girls);

                if(fullnametxt.isEmpty()|| emailtxt.isEmpty()||phonetxt.isEmpty()||passwordtxt.isEmpty()||housetxt.isEmpty()||pintxt.isEmpty()||villagetxt.isEmpty()||citytext.isEmpty()||landmarktxt.isEmpty()){
                    Toast.makeText(detail2.this, "please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if (!passwordtxt.equals(confpasswordtxt)){
                    Toast.makeText(detail2.this, "Password are not matching ", Toast.LENGTH_SHORT).show();
                }
                else  if(phonetxt.length()!=10){
                    Toast.makeText(detail2.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(emailtxt)){
                                Toast.makeText(detail2.this, "Already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("users").child(emailtxt).child("fullname").setValue(fullnametxt);
                                databaseReference.child("users").child(emailtxt).child("houseno").setValue(housetxt);
                                databaseReference.child("users").child(emailtxt).child("phoneno").setValue(phonetxt);
                                databaseReference.child("users").child(emailtxt).child("village").setValue(villagetxt.toUpperCase());
                                databaseReference.child("users").child(emailtxt).child("city").setValue(citytext.toUpperCase());
                                databaseReference.child("users").child(emailtxt).child("pincode").setValue(pintxt);
                                databaseReference.child("users").child(emailtxt).child("password").setValue(passwordtxt);
                                databaseReference.child("users").child(emailtxt).child("landmark").setValue(landmarktxt);
                                databaseReference.child("users").child(emailtxt).child("usertype").setValue(usertype);
                                databaseReference.child("users").child(emailtxt).child("rent").setValue(rentxt);

                                if(rb3.isChecked()){
                                    databaseReference.child("users").child(emailtxt).child("tiffin  service").setValue(rb1.getText().toString());
                                }
                                else if(rb4.isChecked()){
                                    databaseReference.child("users").child(emailtxt).child("tiffin service").setValue(rb2.getText().toString());
                                }
                                if(rb1.isChecked()){
                                    databaseReference.child("users").child(emailtxt).child("pg for").setValue(rb3.getText().toString());
                                }
                                else if (rb2.isChecked()){
                                    databaseReference.child("users").child(emailtxt).child("pg for").setValue(rb4.getText().toString());
                                }
                                Toast.makeText(detail2.this, "USER REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(detail2.this,login.class));
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
                startActivity(new Intent(detail2.this,login.class));
            }
        });
    }
}
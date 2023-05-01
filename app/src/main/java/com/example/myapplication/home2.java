package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home2 extends AppCompatActivity {
    TextView fullname,username;
    EditText phone_e,house,village,pincode,city,landmark,rent,pg;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://pggg-fe0d3-default-rtdb.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        fullname=findViewById(R.id.fullname_text);
        username=findViewById(R.id.Username);
        phone_e=findViewById(R.id.PHONENO);
        house= findViewById(R.id.houseno);
        village=findViewById(R.id.village);
        pincode=findViewById(R.id.Pincode);
        city=findViewById(R.id.City);
        landmark=findViewById(R.id.Landmark);
        rent = findViewById(R.id.rent);



        showdata();
    }
    void showdata(){
        Intent intent=getIntent();
        String user_username=intent.getStringExtra("username");
        String user_name=intent.getStringExtra("name");
        String phone_no=intent.getStringExtra("phoneno");
        String house_no= intent.getStringExtra("houseno");
        String land_mark=intent.getStringExtra("landmark");
        String vill_age= intent.getStringExtra("village");
        String ci_ty=intent.getStringExtra("city");
        String pin_code=intent.getStringExtra("pincode");
        String fee_s=intent.getStringExtra("fees");

        fullname.setText(user_name);
        username.setText(user_username);
        phone_e.setText(phone_no);
        house.setText(house_no);
        landmark.setText(land_mark);
        village.setText(vill_age);
        pincode.setText(pin_code);
        city.setText(ci_ty);
        rent.setText(fee_s);




    }

}

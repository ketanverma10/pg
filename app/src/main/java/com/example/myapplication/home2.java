package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home2 extends AppCompatActivity {
    TextView fullname,username;
    Button bt1;
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

        pincode=findViewById(R.id.Pincode);
        city=findViewById(R.id.City);

        rent = findViewById(R.id.rent);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(home2.this, "Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(home2.this,login.class));
            }
        });



        showdata();
    }
    void showdata(){
        Intent intent=getIntent();
        String user_username=intent.getStringExtra("username");
        String user_name=intent.getStringExtra("name");
        String phone_no=intent.getStringExtra("phoneno");
        String address_s= intent.getStringExtra("address");

        String ci_ty=intent.getStringExtra("city");
        String pin_code=intent.getStringExtra("pincode");
        String fee_s=intent.getStringExtra("fees");

        fullname.setText(user_name);
        username.setText(user_username);
        phone_e.setText(phone_no);
        house.setText(address_s);

        pincode.setText(pin_code);
        city.setText(ci_ty);
        rent.setText(fee_s);




    }

}

package com.example.serversideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class testUpdate extends AppCompatActivity {

    DatabaseReference dbRef;
    Business business;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_update);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World! 3");

       business = new Business("PJ's Pub 3",100,"Pub owned by pj",53.26749733782147,-7.828069925308228,50);

       dbRef = FirebaseDatabase.getInstance().getReference().child("Business_DB").child("pj_pub111");

       dbRef.setValue(business);



    }
}

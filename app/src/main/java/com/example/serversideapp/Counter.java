package com.example.serversideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Counter extends AppCompatActivity {
    int count = 0;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Business_DB").child("pj_pub1");


    }

    public void decrease_by_one(View view) {
        count -= 1;
        dbRef.child("occupancy").setValue(count);
    }

    public void decrease_by_two(View view) {
        count -= 2;
        dbRef.child("occupancy").setValue(count);
    }



    public void increase_by_one(View view) {
        count += 1;
        dbRef.child("occupancy").setValue(count);
    }

    public void increase_by_two(View view) {
        count += 2;
        dbRef.child("occupancy").setValue(count);
    }

}

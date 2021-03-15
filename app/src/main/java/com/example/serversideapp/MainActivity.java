package com.example.serversideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void go_to_test(View view) {
        Intent intent = new Intent(this, testUpdate.class);
        startActivity(intent);
    }

    public void go_to_details(View view) {
        Intent intent = new Intent(this, DetailsScreen.class);
        startActivity(intent);
    }

    public void go_to_counter_screen(View view) {
        Intent intent = new Intent(this, Counter.class);
        startActivity(intent);
    }
}

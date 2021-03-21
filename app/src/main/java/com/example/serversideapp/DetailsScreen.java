package com.example.serversideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DetailsScreen extends AppCompatActivity {

    DatabaseReference dbRef;
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();

    Business business;
    private EditText name_text, description_text, max_capacity_text, latitude_text, longtitude_text, occupancy_text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        //text views
        name_text = findViewById(R.id.business_name_text);
        description_text = findViewById(R.id.description_text);
        max_capacity_text = findViewById(R.id.max_capacity_text);
        latitude_text = findViewById(R.id.latitude_text);
        longtitude_text = findViewById(R.id.longtitude_text);
        occupancy_text = findViewById(R.id.occupancy_text);

        FirebaseDatabase database = FirebaseDatabase.getInstance();



        for (int i =0; i<10; i++) {
            myNumbers.add(i);
        }



    }

    public void save_details(View view) {
        //save stuff
        String name = name_text.getText().toString();
        String description = description_text.getText().toString();
        int max_capacity = Integer.parseInt(max_capacity_text.getText().toString());
        int occupancy = Integer.parseInt(occupancy_text.getText().toString());
        Double latitude = Double.parseDouble(latitude_text.getText().toString());
        Double longtitude = Double.parseDouble(longtitude_text.getText().toString());

        //business = new Business("PJ's Pub 3",100,"Pub owned by pj",53.26749733782147,-7.828069925308228,50);
        business =new Business(name, max_capacity ,description, latitude, longtitude, occupancy , myNumbers);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Business_DB").child("pj_pub2");

        dbRef.setValue(business);

    }
}

package com.example.serversideapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DetailsScreen extends AppCompatActivity {

    DatabaseReference dbRef;
    DatabaseReference dbRefForGet;
   // ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    //List<String>tags;
    Business business_data;


    Business business;
    private EditText tag_text, business_name_text, description_text, max_capacity_text, latitude_text, longtitude_text, occupancy_text;
    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        //text views
        welcomeText = findViewById(R.id.welcomeText);
        business_name_text = findViewById(R.id.business_name_text);
        description_text = findViewById(R.id.description_text);
        max_capacity_text = findViewById(R.id.max_capacity_text);
        latitude_text = findViewById(R.id.latitude_text);
        longtitude_text = findViewById(R.id.longtitude_text);
        occupancy_text = findViewById(R.id.occupancy_text);
        tag_text = findViewById(R.id.tag_text);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        welcomeText.setText("Welcome " + currentFirebaseUser.getDisplayName());
        String userID = currentFirebaseUser.getUid();

        try {
            dbRefForGet = FirebaseDatabase.getInstance().getReference();

            dbRefForGet.child("Business_DB").child(userID).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @SuppressLint("LongLogTag")
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                business_data = dataSnapshot.getValue(Business.class);

                                //loading the data from firebase into textboxes
                                business_name_text.setText(business_data.getBusiness_name());
                                description_text.setText(business_data.getDescription());
                                max_capacity_text.setText(String.valueOf(business_data.getMax_capicity()));
                                latitude_text.setText(String.valueOf(business_data.getLatitude().toString()));
                                longtitude_text.setText(String.valueOf(business_data.getLongtitude().toString()));
                                occupancy_text.setText(String.valueOf(business_data.getOccupency()));
                                tag_text.setText(String.valueOf(business_data.getTags()));

                               // List<String> tags=business_data.getTags();


                            } else {
                                welcomeText.setText("No data in Database yet ");
                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void save_details(View view) {
        //save stuff
        //Check there are no empty texboxes
        if (TextUtils.isEmpty(business_name_text.getText().toString())) {
            Toast.makeText(DetailsScreen.this, "Please enter Business name",
                    Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(description_text.getText().toString())) {
            Toast.makeText(DetailsScreen.this, "Please enter Business description",
                    Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(max_capacity_text.getText().toString())) {
            Toast.makeText(DetailsScreen.this, "Please enter Maximum Capacity",
                    Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(occupancy_text.getText().toString())) {
            Toast.makeText(DetailsScreen.this, "Please enter current occupancy",
                    Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(latitude_text.getText().toString())) {
            Toast.makeText(DetailsScreen.this, "Please enter Latitude",
                    Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(longtitude_text.getText().toString())) {
            Toast.makeText(DetailsScreen.this, "Please enter Longitude",
                    Toast.LENGTH_SHORT).show();
        } else {

            String name = business_name_text.getText().toString();
            String description = description_text.getText().toString();
            int max_capacity = Integer.parseInt(max_capacity_text.getText().toString());
            int occupancy = Integer.parseInt(occupancy_text.getText().toString());
            Double latitude = Double.parseDouble(latitude_text.getText().toString());
            Double longtitude = Double.parseDouble(longtitude_text.getText().toString());
            List<String> tags = Arrays.asList(tag_text.getText().toString().split(","));
            //toString().split("\\s*,\\s*"));

            business = new Business(name, max_capacity, description, latitude, longtitude, occupancy, tags);
            //get the current signed in user and add the business details as a child node under their user uid
            FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            dbRef = FirebaseDatabase.getInstance().getReference().child("Business_DB").child(currentFirebaseUser.getUid());

            dbRef.setValue(business);

            Toast.makeText(DetailsScreen.this,
                    "Business Details Saved",
                    Toast.LENGTH_SHORT).show();


            //Go back to main page after details are saved
            Intent i = new Intent(DetailsScreen.this, HomeActivity.class);
            startActivity(i);


        }
    }
}

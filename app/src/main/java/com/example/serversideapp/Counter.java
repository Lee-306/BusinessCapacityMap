package com.example.serversideapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Counter extends AppCompatActivity {
    int count = 0;
    DatabaseReference dbRef;
    DatabaseReference dbRefForGet;

    Business business_data;

    private TextView count_text;
    private EditText number_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        count_text = findViewById(R.id.count_textview);
        number_input = findViewById(R.id.text_input_number);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String userID = currentFirebaseUser.getUid();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Business_DB").child(currentFirebaseUser.getUid());

        try {
            dbRefForGet = FirebaseDatabase.getInstance().getReference();

            dbRefForGet.child("Business_DB").child(userID).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @SuppressLint("LongLogTag")
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                business_data = dataSnapshot.getValue(Business.class);

                                count_text.setText(String.valueOf(business_data.getOccupancy()));
                                count = business_data.getOccupancy();

                            } else {
                                System.out.println("There is no data to show");
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

    public void decrease_by_one(View view) {
        count -= 1;
        dbRef.child("occupancy").setValue(count);
        count_text.setText(String.valueOf(count));
    }

    public void decrease_by_two(View view) {
        count -= 2;
        dbRef.child("occupancy").setValue(count);
        count_text.setText(String.valueOf(count));
    }



    public void increase_by_one(View view) {
        count += 1;
        dbRef.child("occupancy").setValue(count);
        count_text.setText(String.valueOf(count));
    }

    public void increase_by_two(View view) {
        count += 2;
        dbRef.child("occupancy").setValue(count);
        count_text.setText(String.valueOf(count));
    }

    public void add_custom(View view) {
        int custom_number = Integer.parseInt(String.valueOf(number_input.getText()));

        count += custom_number;
        dbRef.child("occupancy").setValue(count);
        count_text.setText(String.valueOf(count));


    }
    public void subtract_custom(View view) {
        int custom_number = Integer.parseInt(String.valueOf(number_input.getText()));
        if(custom_number > count){
            Toast.makeText(this, "Enter a number smaller than the current occupency" , Toast.LENGTH_SHORT).show();
        }else{
            count -= custom_number;
            dbRef.child("occupancy").setValue(count);
            count_text.setText(String.valueOf(count));
        }
    }

    public void reset_count(View view) {
        count =0;
        dbRef.child("occupancy").setValue(count);
        count_text.setText(String.valueOf(count));
    }
}

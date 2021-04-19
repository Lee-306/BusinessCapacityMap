package com.example.serversideapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class SavedUser extends AppCompatActivity {
    private TextView helloText;
    private EditText tag;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    Business business;
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    //ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    Business business_data;
    String userID;
    FirebaseUser currentFirebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_user);
        //
        helloText = findViewById(R.id.hello);
        tag = findViewById(R.id.tag);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        helloText.setText("Hello " + currentFirebaseUser.getDisplayName());


        //ref = FirebaseDatabase.getInstance().getReference().child("Business_DB").child(currentFirebaseUser.getUid());
        // final FirebaseDatabase database = FirebaseDatabase.getInstance();
        // DatabaseReference ref = database.getReference("Business_DB");


        helloText.setText("Hello " + currentFirebaseUser.getDisplayName());
        String userID = currentFirebaseUser.getUid();



       /* try {
            ref = FirebaseDatabase.getInstance().getReference();

            ref.child("Business_DB").child(userID).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @SuppressLint("LongLogTag")
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                business_data = dataSnapshot.getValue(Business.class);





                            } else {
                                helloText.setText("No Tags in Database yet ");
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
*/
    }
    public void save_tags(View view) {
        //String tag1 = tag.getText().toString();
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        ref = FirebaseDatabase.getInstance().getReference().child("Business_DB").child(currentFirebaseUser.getUid());

        //dbRef.setValue(business);
        ref.child("myNumbers").setValue(tag.getText().toString());

        //business =new Business(name, max_capacity ,description, latitude, longtitude, occupancy , myNumbers);

        String userID = currentFirebaseUser.getUid();
        //currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        Toast.makeText(this, "Your tag is " + tag.getText().toString(), Toast.LENGTH_SHORT).show();

        //Log.e("firebase data", "work ");


    }


    // nameText.setText(ref.child("name").child("description").toString());

// Attach a listener to read the data at our posts reference
        /*ref.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String business_name = dataSnapshot.child(String.valueOf(currentFirebaseUser)).child("business_name").getValue(String.class);
                Business business = dataSnapshot.getValue(Business.class);
                nameText.setText("Name"+business_name);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });*/
        //DatabaseReference uDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Business_DB");

       // firebaseDatabase = FirebaseDatabase.getInstance();
       // dbRef = firebaseDatabase.getReference("Business_DB");

       // DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        //DatabaseReference uidRef = rootRef.child("Business_DB").child(String.valueOf(currentFirebaseUser));

       /* dbRef.child(String.valueOf(currentFirebaseUser)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String business_name = dataSnapshot.child("name").getValue(String.class);
                String descripion = dataSnapshot.child("description").getValue(String.class);
                nameText.setText(business_name);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


*/
        /*ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //String busName = String.valueOf(dataSnapshot.child("name").getValue());
                String name = dataSnapshot.getValue(String.class);
                //nameText.setText(busName);
                nameText.setText(name);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Map<String,String> map = dataSnapshot.getValue(Map.class);
                String name = map.get("name");
                String descript = map.get("description");
                nameText.setText(name);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


*/









/*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String busName = String.valueOf(dataSnapshot.child("name").getValue());
                //String business_name = dataSnapshot.child("name").getValue(String.class);
                //String descripion = dataSnapshot.child("description").getValue(String.class);
                nameText.setText(busName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/

       // dbRef.addListenerForSingleValueEvent(valueEventListener);
        //getdata();
    }
    //DatabaseReference databaseReference = dbRef.getReference("Business_DB").child(currentFirebaseUser.getUid());

   /* private void getdata() {
        ref.addValueEventListener(new ValueEventListener() {
            private static final String TAG = "Failed: ";


            @Override
            //name, max_capacity ,description, latitude, longtitude, occupancy , myNumbers
            public void onDataChange(DataSnapshot dataSnapshot) {

                //String email = dataSnapshot.child("Email").getValue(String.class);
                String business_name = dataSnapshot.child("name").getValue(String.class);
                String descripion = dataSnapshot.child("description").getValue(String.class);
                nameText.setText(business_name);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/

        //based on userID, directory will change dynamically
        //nameText.setText("Business name : "+dbRef.setValue())

        //welcomeText = findViewById(R.id.welcomeText);
        // FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        //dbRef = FirebaseDatabase.getInstance().getReference().child("Business_DB").child(currentFirebaseUser.getDisplayName());
        //welcomeText.setText("Welcome "+currentFirebaseUser.getDisplayName());
        //Toast.makeText(this, "" + currentFirebaseUser.getDisplayName(), Toast.LENGTH_SHORT).show();


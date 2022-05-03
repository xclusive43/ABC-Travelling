package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class mybooking extends AppCompatActivity {

    ListView ticketslist;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    TextView ticketid,busfare,date,time,from1,to1,busname,seatsno,passengername,age,address,gender,mobile;
    String tickets_id,from;
    LinearLayout linearLayout14;
    ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybooking);

        ticketid = findViewById(R.id.ticketid);
        busfare = findViewById(R.id.busfare);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        busname = findViewById(R.id.busname);
        seatsno = findViewById(R.id.seatname);
        from1= findViewById(R.id.from);
        to1= findViewById(R.id.to);
        passengername = findViewById(R.id.passengername);
        age = findViewById(R.id.age);
        mobile = findViewById(R.id.mobile);
        gender = findViewById(R.id.gender);
        address = findViewById(R.id.address);

        linearLayout14 = findViewById(R.id.linearLayout14);
        progressBar1 = findViewById(R.id.progressbook);

        // ticketslist = findViewById(R.id.listticket);



        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        progressBar1.setVisibility(View.VISIBLE);

        DatabaseReference reff = FirebaseDatabase.getInstance().getReference("tickets_bookings").child(firebaseAuth.getUid());
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                //tickerbar.setVisibility(View.GONE);
                if(!dataSnapshot.exists())
                {
                   Toast.makeText(mybooking.this,"No Tickets Found!",Toast.LENGTH_SHORT).show();
                   progressBar1.setVisibility(View.GONE);
                }
                else {

                    tickets_id= dataSnapshot.child("b1").getValue().toString();//working fine



                    DatabaseReference reff = FirebaseDatabase.getInstance().getReference("all_tickets").child(tickets_id);
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //tickerbar.setVisibility(View.GONE);
                            if(!dataSnapshot.exists())
                            {
                                Toast.makeText(mybooking.this,"No Tickets Found!",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                //tickets_id= dataSnapshot.child("b1").getValue().toString();//working fine
                                progressBar1.setVisibility(View.GONE);
                                linearLayout14.setVisibility(View.VISIBLE);

                                ticketid.setText(dataSnapshot.child("tickekid").getValue().toString());
                                busfare.setText(dataSnapshot.child("busfare").getValue().toString());
                                date.setText(dataSnapshot.child("date").getValue().toString());
                                time.setText(dataSnapshot.child("time").getValue().toString());
                                busname.setText(dataSnapshot.child("busname").getValue().toString());
                                seatsno.setText(dataSnapshot.child("seatsname").getValue().toString());
                                from1.setText(dataSnapshot.child("from").getValue().toString());
                                to1.setText(dataSnapshot.child("to").getValue().toString());
                                passengername.setText(dataSnapshot.child("name1").getValue().toString());
                                age.setText(dataSnapshot.child("age").getValue().toString());
                                gender.setText(dataSnapshot.child("gender").getValue().toString());
                                mobile.setText(dataSnapshot.child("mobile").getValue().toString());
                                address.setText(dataSnapshot.child("address").getValue().toString());




                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            //tickerbar.setVisibility(View.GONE);

                            Toast.makeText(mybooking.this,"No Tickets Found!",Toast.LENGTH_SHORT).show();

                        }
                    });



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //tickerbar.setVisibility(View.GONE);

                Toast.makeText(mybooking.this,"No Tickets Found!",Toast.LENGTH_SHORT).show();

            }
        });








}
}

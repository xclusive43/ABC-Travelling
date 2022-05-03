package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class ticketing extends AppCompatActivity  {
     Spinner city1,city2;
     TextView city11,city22,datetext,busname1;
     Button date,search;
     DatePickerDialog dpd;
     Calendar c;
     String totalseats,remainingseats,bookedseats, busid,busname,timing,price;
     String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26;
     ProgressBar tickerbar;

    String cityname[] = {"select a place","Shillong","Tura"},record,record1,dat,realdate;
    ArrayAdapter <String> adapapter,adapapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketing);

        city1 = findViewById(R.id.city1);
        city2 = findViewById(R.id.city2);
        city11 = findViewById(R.id.citya);
        city22  = findViewById(R.id.cityb);
        date = findViewById(R.id.date);
        datetext = findViewById(R.id.dateText);
        busname1 = findViewById(R.id.bussname);
        search = findViewById(R.id.ticketsearch);
        tickerbar = findViewById(R.id.progressticket);


        //Button colotbtn = findViewById(R.id.btncolor);

        busname = getIntent().getStringExtra("val");
        busid = getIntent().getStringExtra("val1");
        busname1.setText(getIntent().getStringExtra("val"));//from index buss name


        adapapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityname);//spinnner datas selection
        city1.setAdapter(adapapter);

        city1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0: record ="select a place";
                    break;

                    case 1: record = "shillong";
                    break;

                    case 2: record = "tura";
                    break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        adapapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityname);//spinnner datas selection
        city2.setAdapter(adapapter1);

        city2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0: record1 ="select a place";
                        break;

                    case 1: record1 = "shillong";
                        break;

                    case 2: record1 = "tura";
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year= c.get(Calendar.YEAR);

              dpd = new DatePickerDialog(ticketing.this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
                       dat = mdayOfMonth+ "" +(mmonth+1) + "" + myear;
                       datetext.setText(mdayOfMonth+ "/" +(mmonth+1) + "/" + myear );
                       realdate = mdayOfMonth+ "/" +(mmonth+1) + "/" + myear;

                  }
              },year,month,day);

              dpd.show();

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m = "select a place";
                if(record.matches(m) )
                {
                    Toast.makeText(ticketing.this,"please select Source!",Toast.LENGTH_SHORT).show();
                }
                else if(record1.matches(m) )
                {
                    Toast.makeText(ticketing.this,"please select destination!",Toast.LENGTH_SHORT).show();
                }

                else if(record1 == record)
                {
                    Toast.makeText(ticketing.this,"Source and Destination cannot be same!",Toast.LENGTH_SHORT).show();
                }
                else  if (datetext.length() == 0)
                {
                    Toast.makeText(ticketing.this,"Date cannot be empty!",Toast.LENGTH_SHORT).show();
                }
                else
                {   tickerbar.setVisibility(View.VISIBLE);


                   DatabaseReference reff = FirebaseDatabase.getInstance().getReference("busdetails").child(busid).child(record).child(record1).child("dates").child(dat);
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            tickerbar.setVisibility(View.GONE);
                            if(!dataSnapshot.exists())
                            {
                                Toast.makeText(ticketing.this,"Bus not availbale at the provided date!",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                totalseats = dataSnapshot.child("totalseats").getValue().toString();//working fine
                                remainingseats = dataSnapshot.child("remainingseats").getValue().toString();
                                bookedseats = dataSnapshot.child("bookedseats").getValue().toString();
                                timing = dataSnapshot.child("timing").getValue().toString();
                                price = dataSnapshot.child("busfare").getValue().toString();

                                s1 = dataSnapshot.child("s1").getValue().toString();
                                s2 = dataSnapshot.child("s2").getValue().toString();
                                s3 = dataSnapshot.child("s3").getValue().toString();
                                s4 = dataSnapshot.child("s4").getValue().toString();
                                s5 = dataSnapshot.child("s5").getValue().toString();
                                s6 = dataSnapshot.child("s6").getValue().toString();
                                s7 = dataSnapshot.child("s7").getValue().toString();
                                s8 = dataSnapshot.child("s8").getValue().toString();
                                s9 = dataSnapshot.child("s9").getValue().toString();
                                s10 = dataSnapshot.child("s10").getValue().toString();
                                s11 = dataSnapshot.child("s11").getValue().toString();
                                s12 = dataSnapshot.child("s12").getValue().toString();
                                s13 = dataSnapshot.child("s13").getValue().toString();
                                s14 = dataSnapshot.child("s14").getValue().toString();
                                s15 = dataSnapshot.child("s15").getValue().toString();
                                s16 = dataSnapshot.child("s16").getValue().toString();
                                s17 = dataSnapshot.child("s17").getValue().toString();
                                s18 = dataSnapshot.child("s18").getValue().toString();
                                s19 = dataSnapshot.child("s19").getValue().toString();
                                s20 = dataSnapshot.child("s20").getValue().toString();
                                s21 = dataSnapshot.child("s21").getValue().toString();
                                s22 = dataSnapshot.child("s22").getValue().toString();
                                s23 = dataSnapshot.child("s23").getValue().toString();
                                s24 = dataSnapshot.child("s24").getValue().toString();
                                s25 = dataSnapshot.child("s25").getValue().toString();
                                s26 = dataSnapshot.child("s26").getValue().toString();


                                Intent intents = new Intent(ticketing.this, ticketing_2.class);
                                intents.putExtra("totalseats", totalseats);
                                intents.putExtra("remainingseats", remainingseats);
                                intents.putExtra("bookedseats", bookedseats);
                                intents.putExtra("from", record);
                                intents.putExtra("to", record1);
                                intents.putExtra("date", dat);
                                intents.putExtra("busid", busid);
                                intents.putExtra("busname", busname);
                                intents.putExtra("realdate", realdate);
                                intents.putExtra("timing", timing);
                                intents.putExtra("price", price);

                                intents.putExtra("s1", s1);
                                intents.putExtra("s2", s2);
                                intents.putExtra("s3", s3);
                                intents.putExtra("s4", s4);
                                intents.putExtra("s5", s5);
                                intents.putExtra("s6", s6);
                                intents.putExtra("s7", s7);
                                intents.putExtra("s8", s8);
                                intents.putExtra("s9", s9);
                                intents.putExtra("s10", s10);
                                intents.putExtra("s11", s11);
                                intents.putExtra("s12", s12);
                                intents.putExtra("s13", s13);
                                intents.putExtra("s14", s14);
                                intents.putExtra("s15", s15);
                                intents.putExtra("s16", s16);
                                intents.putExtra("s17", s17);
                                intents.putExtra("s18", s18);
                                intents.putExtra("s19", s19);
                                intents.putExtra("s20", s20);
                                intents.putExtra("s21", s21);
                                intents.putExtra("s22", s22);
                                intents.putExtra("s23", s23);
                                intents.putExtra("s24", s24);
                                intents.putExtra("s25", s25);
                                intents.putExtra("s26", s26);

                                startActivity(intents);

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            tickerbar.setVisibility(View.GONE);

                            Toast.makeText(ticketing.this,"Data not found please select a valid date!",Toast.LENGTH_SHORT).show();

                        }
                    });
  }


            }
        });



    }


}


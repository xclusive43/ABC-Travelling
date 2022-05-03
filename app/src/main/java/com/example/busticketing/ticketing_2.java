package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ticketing_2 extends AppCompatActivity {
    TextView busname,busfrom,busto,date1,totalseats,bookedseats,remaininigseats,timing1,counter2,busfare;
    Button selectbtn,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,refreshbtn;
    String  ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8,ss9,ss10,ss11,ss12,ss13,ss14,ss15,ss16,ss17,ss18,ss19,ss20,ss21,ss22,ss23,ss24,ss25,ss26;
    String  sss1 ="0",sss2="0",sss3="0",sss4="0",sss5="0",sss6="0",sss7="0",sss8="0",sss9="0",sss10="0",sss11="0",sss12="0",sss13="0"
            ,sss14="0",sss15="0",sss16="0",sss17="0",sss18="0",sss19="0",sss20="0",sss21="0",sss22="0",sss23="0",sss24="0",sss25="0",sss26="0";

    String timing2,busfare2,totalsetas2,remainingseats2,bookedseats2, busname1,busid1,from1,to1,date11,busdate;

    String counter1 = "0";
    int c ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketing_2);

        busname = findViewById(R.id.busname1);
        busfare = findViewById(R.id.busfare);
        refreshbtn = findViewById(R.id.refreshbtn);
        timing1 = findViewById(R.id.timing1);
        busfrom = findViewById(R.id.from1);
        busto= findViewById(R.id.to1);
        date1 = findViewById(R.id.date1);
        totalseats = findViewById(R.id.totalseats1);
        remaininigseats = findViewById(R.id.remainingseats1);
        bookedseats = findViewById(R.id.bookedseats1);
        selectbtn = findViewById(R.id.select1);

        s1 = findViewById(R.id.s1);s2 = findViewById(R.id.s2); s3 = findViewById(R.id.s3); s4  = findViewById(R.id.s4); s5 =findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);s7 = findViewById(R.id.s7); s8 = findViewById(R.id.s8); s9  = findViewById(R.id.s9); s10 =findViewById(R.id.s10);
        s11 = findViewById(R.id.s11);s12 = findViewById(R.id.s12); s13 = findViewById(R.id.s13); s14  = findViewById(R.id.s14); s15 =findViewById(R.id.s15);
        s16 = findViewById(R.id.s16);s17 = findViewById(R.id.s17); s18 = findViewById(R.id.s18); s19  = findViewById(R.id.s19); s20=findViewById(R.id.s20);
        s21 = findViewById(R.id.s21);s22 = findViewById(R.id.s22); s23 = findViewById(R.id.s23); s24  = findViewById(R.id.s24); s25 =findViewById(R.id.s25);
        s26 = findViewById(R.id.s26);

        //assiging values to textview
        busname.setText(getIntent().getStringExtra("busname").toUpperCase());
        busfrom.setText(getIntent().getStringExtra("from").toUpperCase());
        busto.setText(getIntent().getStringExtra("to").toUpperCase());
        date1.setText(getIntent().getStringExtra("realdate"));
        totalseats.setText(getIntent().getStringExtra("totalseats"));
        bookedseats.setText(getIntent().getStringExtra("bookedseats"));
        remaininigseats.setText(getIntent().getStringExtra("remainingseats"));
        timing1.setText(getIntent().getStringExtra("timing"));
        busfare.setText(getIntent().getStringExtra("price"));


        //assigning forword data for next activity

        ss1 = getIntent().getStringExtra("s1");
        ss2 =getIntent().getStringExtra("s2");
        ss3 = getIntent().getStringExtra("s3");
        ss4 = getIntent().getStringExtra("s4");
        ss5 = getIntent().getStringExtra("s5");
        ss6 = getIntent().getStringExtra("s6");
        ss7 = getIntent().getStringExtra("s7");
        ss8 = getIntent().getStringExtra("s8");
        ss9 = getIntent().getStringExtra("s9");
        ss10 = getIntent().getStringExtra("s10");
        ss11 = getIntent().getStringExtra("s11");
        ss12 = getIntent().getStringExtra("s12");
        ss13 = getIntent().getStringExtra("s13");
        ss14 = getIntent().getStringExtra("s14");
        ss15 = getIntent().getStringExtra("s15");
        ss16 = getIntent().getStringExtra("s16");
        ss17 = getIntent().getStringExtra("s17");
        ss18 = getIntent().getStringExtra("s18");
        ss19 = getIntent().getStringExtra("s19");
        ss20 = getIntent().getStringExtra("s20");
        ss21 = getIntent().getStringExtra("s21");
        ss22 = getIntent().getStringExtra("s22");
        ss23 = getIntent().getStringExtra("s23");
        ss24 = getIntent().getStringExtra("s24");
        ss25 = getIntent().getStringExtra("s25");
        ss26 = getIntent().getStringExtra("s26");



        //busid1,from1,to1,date11,busid,timing;

        busname1  = getIntent().getStringExtra("busname");
        busid1  = getIntent().getStringExtra("busid");
        from1  = getIntent().getStringExtra("from");
        to1  = getIntent().getStringExtra("to");
        date11  = getIntent().getStringExtra("realdate");
        busfare2 = getIntent().getStringExtra("price");
        timing2 = getIntent().getStringExtra("timing");
        totalsetas2 = getIntent().getStringExtra("totalseats");
        bookedseats2 =getIntent().getStringExtra("bookedseats");
        remainingseats2 =getIntent().getStringExtra("remainingseats");
        busdate =getIntent().getStringExtra("date");


        ceckdata();

        refreshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });


        selectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String co = "0";
                if(counter1.matches(co))
                {
                    Toast.makeText(ticketing_2.this,"select a seat!",Toast.LENGTH_SHORT).show();
                }

                else
                {


                    Intent intent21 = new Intent(ticketing_2.this,ticketing3.class);

                    intent21.putExtra("busname1",busname1);
                    intent21.putExtra("from1",from1);
                    intent21.putExtra("to1",to1);
                    intent21.putExtra("date1",date11);
                    intent21.putExtra("busfare1",busfare2);
                    intent21.putExtra("timing1",timing2);
                    intent21.putExtra("totalbooked1",totalsetas2);
                    intent21.putExtra("remainingseats1",remainingseats2);
                    intent21.putExtra("bookedseats1",bookedseats2);
                    intent21.putExtra("counter1",counter1);
                    intent21.putExtra("busid1",busid1);
                    intent21.putExtra("busdate",busdate);

                    //seats names for insearting into database = tickets name
                    intent21.putExtra("s1",sss1);
                    intent21.putExtra("s2",sss2);
                    intent21.putExtra("s3",sss3);
                    intent21.putExtra("s4",sss4);
                    intent21.putExtra("s5",sss5);

                    intent21.putExtra("s6",sss6);
                    intent21.putExtra("s7",sss7);
                    intent21.putExtra("s8",sss8);
                    intent21.putExtra("s9",sss9);
                    intent21.putExtra("s10",sss10);
                    intent21.putExtra("s11",sss11);
                    intent21.putExtra("s12",sss12);
                    intent21.putExtra("s13",sss13);
                    intent21.putExtra("s14",sss14);
                    intent21.putExtra("s15",sss15);
                    intent21.putExtra("s16",sss16);
                    intent21.putExtra("s17",sss17);
                    intent21.putExtra("s18",sss18);
                    intent21.putExtra("s19",sss19);
                    intent21.putExtra("s20",sss20);
                    intent21.putExtra("s21",sss21);
                    intent21.putExtra("s22",sss22);
                    intent21.putExtra("s23",sss23);
                    intent21.putExtra("s24",sss24);
                    intent21.putExtra("s25",sss25);
                    intent21.putExtra("s26",sss26);

                     //for updating seats in database
                    intent21.putExtra("ss1",ss1);
                    intent21.putExtra("ss2",ss2);
                    intent21.putExtra("ss3",ss3);
                    intent21.putExtra("ss4",ss4);
                    intent21.putExtra("ss5",ss5);
                    intent21.putExtra("ss6",ss6);
                    intent21.putExtra("ss7",ss7);
                    intent21.putExtra("ss8",ss8);
                    intent21.putExtra("ss9",ss9);
                    intent21.putExtra("ss10",ss10);
                    intent21.putExtra("ss11",ss11);
                    intent21.putExtra("ss12",ss12);
                    intent21.putExtra("ss13",ss13);
                    intent21.putExtra("ss14",ss14);
                    intent21.putExtra("ss15",ss15);
                    intent21.putExtra("ss16",ss16);
                    intent21.putExtra("ss17",ss17);
                    intent21.putExtra("ss18",ss18);
                    intent21.putExtra("ss19",ss19);
                    intent21.putExtra("ss20",ss20);
                    intent21.putExtra("ss21",ss21);
                    intent21.putExtra("ss22",ss22);
                    intent21.putExtra("ss23",ss23);
                    intent21.putExtra("ss24",ss24);
                    intent21.putExtra("ss25",ss25);
                    intent21.putExtra("ss26",ss26);



                    startActivity(intent21);
                    intent21.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent21.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    finish();


                }


            }
        });









        }


 //from firebase //
    private void ceckdata() {//working good for buttons
         String m1= "1";
         String m2 = "0";
        if(ss1.matches(m1))
        {
            s1.setBackgroundResource(R.color.red);
            s1.setEnabled(false);
        }

        if(ss1.matches(m2))
        {
            s1.setBackgroundResource(R.color.greencolor);
            s1.setEnabled(true);

            s1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    s1.setBackgroundResource(R.color.orange);
                    s1.setEnabled(false);
                     sss1 = "s1";
                     ss1 = "1";
                     c = Integer.parseInt(counter1);
                     c = c + 1;

                     counter1 = Integer.toString(c);




                }
            });

        }

        if(ss2.matches(m1))
        {
            s2.setBackgroundResource(R.color.red);
            s2.setEnabled(false);
        }
        if(ss2.matches(m2))
        {
            s2.setBackgroundResource(R.color.greencolor);
            s2.setEnabled(true);

            s2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s2.setBackgroundResource(R.color.orange);
                    s2.setEnabled(false);
                    sss2 = "s2";
                    ss2 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }

        if(ss3.matches(m1))
        {
            s3.setBackgroundResource(R.color.red);
            s3.setEnabled(false);
        }
        if(ss3.matches(m2))
        {
            s3.setBackgroundResource(R.color.greencolor);
            s3.setEnabled(true);
            s3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s3.setBackgroundResource(R.color.orange);
                    s3.setEnabled(false);
                    sss3 = "s3";
                    ss3 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);


                }
            });


        }

        if(ss4.matches(m1))
        {
            s4.setBackgroundResource(R.color.red);
            s4.setEnabled(false);
        }
        if(ss4.matches(m2))
        {
            s4.setBackgroundResource(R.color.greencolor);
            s4.setEnabled(true);

            s4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s4.setBackgroundResource(R.color.orange);
                    s4.setEnabled(false);
                    sss4 = "s4";
                    ss4 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);


                }
            });

        }



        if(ss5.matches(m1))
        {
            s5.setBackgroundResource(R.color.red);
            s5.setEnabled(false);
        }
        if(ss5.matches(m2))
        {
            s5.setBackgroundResource(R.color.greencolor);
            s5.setEnabled(true);
            s5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s5.setBackgroundResource(R.color.orange);
                    s5.setEnabled(false);
                    sss5 = "s5";
                    ss5 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }




        if(ss6.matches(m1))
        {
            s6.setBackgroundResource(R.color.red);
            s6.setEnabled(false);
        }
        if(ss6.matches(m2))
        {
            s6.setBackgroundResource(R.color.greencolor);
            s6.setEnabled(true);
            s6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s6.setBackgroundResource(R.color.orange);
                    s6.setEnabled(false);
                    sss6 = "s6";
                    ss6 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss7.matches(m1))
        {
            s7.setBackgroundResource(R.color.red);
            s7.setEnabled(false);
        }
        if(ss7.matches(m2))
        {
            s7.setBackgroundResource(R.color.greencolor);
            s7.setEnabled(true);
            s7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s7.setBackgroundResource(R.color.orange);
                    s7.setEnabled(false);
                    sss7 = "s7";
                    ss7 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss8.matches(m1))
        {
            s8.setBackgroundResource(R.color.red);
            s8.setEnabled(false);
        }
        if(ss8.matches(m2))
        {
            s8.setBackgroundResource(R.color.greencolor);
            s8.setEnabled(true);
            s8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s8.setBackgroundResource(R.color.orange);
                    s8.setEnabled(false);
                    sss8 = "s8";
                    ss8 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }


        if(ss9.matches(m1))
        {
            s9.setBackgroundResource(R.color.red);
            s9.setEnabled(false);
        }
        if(ss9.matches(m2))
        {
            s9.setBackgroundResource(R.color.greencolor);
            s9.setEnabled(true);
            s9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s9.setBackgroundResource(R.color.orange);
                    s9.setEnabled(false);
                    sss9 = "s9";
                    ss9 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }

        if(ss10.matches(m1)) {
            s10.setBackgroundResource(R.color.red);
            s10.setEnabled(false);
        }
        if(ss10.matches(m2))
        {
            s10.setBackgroundResource(R.color.greencolor);
            s10.setEnabled(true);
            s10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s10.setBackgroundResource(R.color.orange);
                    s10.setEnabled(false);
                    sss10 = "s10";
                    ss10 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss11.matches(m1)) {
            s11.setBackgroundResource(R.color.red);
            s11.setEnabled(false);
        }
        if(ss11.matches(m2))
        {
            s11.setBackgroundResource(R.color.greencolor);
            s11.setEnabled(true);
            s11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s11.setBackgroundResource(R.color.orange);
                    s11.setEnabled(false);
                    sss11 = "s11";
                    ss11 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss12.matches(m1)) {
            s12.setBackgroundResource(R.color.red);
            s12.setEnabled(false);
        }
        if(ss12.matches(m2))
        {
            s12.setBackgroundResource(R.color.greencolor);
            s12.setEnabled(true);
            s12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s12.setBackgroundResource(R.color.orange);
                    s12.setEnabled(false);
                    sss12 = "s12";
                    ss12 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }




        if(ss13.matches(m1)) {
            s13.setBackgroundResource(R.color.red);
            s13.setEnabled(false);
        }
        if(ss13.matches(m2))
        {
            s13.setBackgroundResource(R.color.greencolor);
            s13.setEnabled(true);
            s13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s13.setBackgroundResource(R.color.orange);
                    s13.setEnabled(false);
                    sss13 = "s13";
                    ss13 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }




        if(ss14.matches(m1)) {
            s14.setBackgroundResource(R.color.red);
            s14.setEnabled(false);
        }
        if(ss14.matches(m2))
        {
            s14.setBackgroundResource(R.color.greencolor);
            s14.setEnabled(true);
            s14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s14.setBackgroundResource(R.color.orange);
                    s14.setEnabled(false);
                    sss14 = "s14";
                    ss14 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss15.matches(m1)) {
            s15.setBackgroundResource(R.color.red);
            s15.setEnabled(false);
        }
        if(ss15.matches(m2))
        {
            s15.setBackgroundResource(R.color.greencolor);
            s15.setEnabled(true);
            s15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s15.setBackgroundResource(R.color.orange);
                    s15.setEnabled(false);
                    sss15 = "s15";
                    ss15 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss16.matches(m1)) {
            s16.setBackgroundResource(R.color.red);
            s16.setEnabled(false);
        }
        if(ss16.matches(m2))
        {
            s16.setBackgroundResource(R.color.greencolor);
            s16.setEnabled(true);
            s16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s16.setBackgroundResource(R.color.orange);
                    s16.setEnabled(false);
                    sss16 = "s16";
                    ss16 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }


        if(ss17.matches(m1)) {
            s17.setBackgroundResource(R.color.red);
            s17.setEnabled(false);
        }
        if(ss17.matches(m2))
        {
            s17.setBackgroundResource(R.color.greencolor);
            s17.setEnabled(true);
            s17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s17.setBackgroundResource(R.color.orange);
                    s17.setEnabled(false);
                    sss17 = "s17";
                    ss17 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }


        if(ss18.matches(m1)) {
            s18.setBackgroundResource(R.color.red);
            s18.setEnabled(false);
        }
        if(ss18.matches(m2))
        {
            s18.setBackgroundResource(R.color.greencolor);
            s18.setEnabled(true);

            s18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s18.setBackgroundResource(R.color.orange);
                    s18.setEnabled(false);
                    sss18 = "s18";
                    ss18 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss19.matches(m1)) {
            s19.setBackgroundResource(R.color.red);
            s19.setEnabled(false);
        }
        if(ss19.matches(m2))
        {
            s19.setBackgroundResource(R.color.greencolor);
            s19.setEnabled(true);
            s19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s19.setBackgroundResource(R.color.orange);
                    s19.setEnabled(false);
                    sss19 = "s19";
                    ss19 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss20.matches(m1)) {
            s20.setBackgroundResource(R.color.red);
            s20.setEnabled(false);
        }
        if(ss20.matches(m2))
        {
            s20.setBackgroundResource(R.color.greencolor);
            s20.setEnabled(true);
            s20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s20.setBackgroundResource(R.color.orange);
                    s20.setEnabled(false);
                    sss20 = "s20";
                    ss20 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss21.matches(m1)) {
            s21.setBackgroundResource(R.color.red);
            s21.setEnabled(false);
        }
        if(ss21.matches(m2))
        {
            s21.setBackgroundResource(R.color.greencolor);
            s21.setEnabled(true);
            s21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s21.setBackgroundResource(R.color.orange);
                    s21.setEnabled(false);
                    sss21 = "s21";
                    ss21 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });
        }


        if(ss22.matches(m1)) {
            s22.setBackgroundResource(R.color.red);
            s22.setEnabled(false);
        }
        if(ss22.matches(m2))
        {
            s22.setBackgroundResource(R.color.greencolor);
            s22.setEnabled(true);
            s22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s22.setBackgroundResource(R.color.orange);
                    s22.setEnabled(false);
                    sss22 = "s22";
                    ss22 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss23.matches(m1)) {
            s23.setBackgroundResource(R.color.red);
            s23.setEnabled(false);
        }
        if(ss23.matches(m2))
        {
            s23.setBackgroundResource(R.color.greencolor);
            s23.setEnabled(true);
            s23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s23.setBackgroundResource(R.color.orange);
                    s23.setEnabled(false);
                    sss23 = "s23";
                    ss23 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss24.matches(m1)) {
            s24.setBackgroundResource(R.color.red);
            s24.setEnabled(false);
        }
        if(ss24.matches(m2))
        {
            s24.setBackgroundResource(R.color.greencolor);
            s24.setEnabled(true);
            s24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s24.setBackgroundResource(R.color.orange);
                    s24.setEnabled(false);
                    sss24 = "s24";
                    ss24 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss25.matches(m1)) {
            s25.setBackgroundResource(R.color.red);
            s25.setEnabled(false);
        }
        if(ss25.matches(m2))
        {
            s25.setBackgroundResource(R.color.greencolor);
            s25.setEnabled(true);
            s25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s25.setBackgroundResource(R.color.orange);
                    s25.setEnabled(false);
                    sss25 = "s25";
                    ss25 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }



        if(ss26.matches(m1)) {
            s26.setBackgroundResource(R.color.red);
            s26.setEnabled(false);
        }
        if(ss26.matches(m2))
        {
            s26.setBackgroundResource(R.color.greencolor);
            s26.setEnabled(true);
            s26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s26.setBackgroundResource(R.color.orange);
                    s26.setEnabled(false);
                    sss26 = "s26";
                    ss26 = "1";
                    c = Integer.parseInt(counter1);
                    c = c + 1;

                    counter1 = Integer.toString(c);

                }
            });

        }







    }


}

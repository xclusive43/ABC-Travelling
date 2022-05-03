package com.example.busticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ticketing3 extends AppCompatActivity {

    TextView from1,to1,date1,timing1,seatno1,busfare1,busname1;

    EditText pass1,age1,mobile1,gender1,address1;

    String from2,to2,date2,realdate2,timing2,busname2,busfare2,seatno2,passengername2,age2,mobile2,address2,gender2;
    String busfare,counter1,totalseats,remainingseats,bookedseats,busid;

    String  ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8,ss9,ss10,ss11,ss12,ss13,ss14,ss15,ss16,ss17,ss18,ss19,ss20,ss21,ss22,ss23,ss24,ss25,ss26;


    int totalfare,seats, total, remainingseats1, bookedseats1;
    String  s1 ="0",s2="0",s3="0",s4="0",s5="0",s6="0",s7="0",s8="0",s9="0",s10="0",s11="0",s12="0",s13="0"
            ,s14="0",s15="0",s16="0",s17="0",s18="0",s19="0",s20="0",s21="0",s22="0",s23="0",s24="0",s25="0",s26="0";
    String seatsname=" ";
    String c,ctotalseats,cremainingseats,cbookedseats,busdate;
    Button pay1;
    ProgressBar pro1;


    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketing3);
        //text1 = findViewById(R.id.tb1);
        busname1 = findViewById(R.id.busname2);
        from1 = findViewById(R.id.from2);
        to1 = findViewById(R.id.to2);
        date1 = findViewById(R.id.date2);
        timing1 = findViewById(R.id.timing2);
        seatno1 = findViewById(R.id.seatno2);
        busfare1 = findViewById(R.id.busfare2);

        pass1 = findViewById(R.id.pass1);
        age1 = findViewById(R.id.age1);
        mobile1 = findViewById(R.id.moblie1);
        gender1 = findViewById(R.id.gender1);
        address1 = findViewById(R.id.address1);

         pay1 = findViewById(R.id.pay1);
         pro1 = findViewById(R.id.pro1);



         busname1.setText(getIntent().getStringExtra("busname1").toUpperCase());
         from1.setText(getIntent().getStringExtra("from1").toUpperCase());
         to1.setText(getIntent().getStringExtra("to1").toUpperCase());
         date1.setText(getIntent().getStringExtra("date1"));
         timing1.setText(getIntent().getStringExtra("timing1"));

         busname2 = getIntent().getStringExtra("busname1");
         from2 = getIntent().getStringExtra("from1");
         to2 = getIntent().getStringExtra("to1");
         date2  = getIntent().getStringExtra("date1");
         timing2 = getIntent().getStringExtra("timing1");
         busdate = getIntent().getStringExtra("busdate");



         busfare =getIntent().getStringExtra("busfare1");
         counter1 =getIntent().getStringExtra("counter1");
         totalseats =getIntent().getStringExtra("totalbooked1");
         remainingseats=getIntent().getStringExtra("remainingseats1");
         bookedseats =getIntent().getStringExtra("bookedseats1");
         busid =getIntent().getStringExtra("busid1");

         //seats calculation and totalfare calculation

        seats = Integer.parseInt(counter1);
        totalfare = Integer.parseInt(busfare);
        totalfare = totalfare * seats;

        c = Integer.toString(totalfare);
        busfare1.setText(c);//total busfare

        //total seats calculation
        total = Integer.parseInt(remainingseats);
        total = total - seats;
        ctotalseats = Integer.toString(total);


        //remaining seats
        //remainingseats1 = Integer.parseInt(remainingseats);
        //remainingseats1 = remainingseats1 - seats;
        //cremainingseats = Integer.toString(remainingseats1);


        //booked seats calculation

         bookedseats1 = Integer.parseInt(bookedseats);

         bookedseats1 = bookedseats1 + seats;

         cbookedseats = Integer.toString(bookedseats1);


        //getting the seats number like s1 s2

        s1  = getIntent().getStringExtra("s1");
        s2  = getIntent().getStringExtra("s2");
        s3  = getIntent().getStringExtra("s3");
        s4  = getIntent().getStringExtra("s4");
        s5  = getIntent().getStringExtra("s5");
        s6  = getIntent().getStringExtra("s6");
        s7  = getIntent().getStringExtra("s7");
        s8  = getIntent().getStringExtra("s8");
        s9  = getIntent().getStringExtra("s9");
        s10 = getIntent().getStringExtra("s10");
        s11 = getIntent().getStringExtra("s11");
        s12 = getIntent().getStringExtra("s12");
        s13 = getIntent().getStringExtra("s13");
        s14 = getIntent().getStringExtra("s14");
        s15 = getIntent().getStringExtra("s15");
        s16 = getIntent().getStringExtra("s16");
        s17 = getIntent().getStringExtra("s17");
        s18 = getIntent().getStringExtra("s18");
        s19 = getIntent().getStringExtra("s19");
        s20 = getIntent().getStringExtra("s20");
        s21 = getIntent().getStringExtra("s21");
        s22 = getIntent().getStringExtra("s22");
        s23 = getIntent().getStringExtra("s23");
        s24 = getIntent().getStringExtra("s24");
        s25 = getIntent().getStringExtra("s25");
        s26 = getIntent().getStringExtra("s26");

        //seats for updateing in database eg s1 = 1 or s1 =0

        ss1 = getIntent().getStringExtra("ss1");
        ss2 =getIntent().getStringExtra("ss2");
        ss3 = getIntent().getStringExtra("ss3");
        ss4 = getIntent().getStringExtra("ss4");
        ss5 = getIntent().getStringExtra("ss5");
        ss6 = getIntent().getStringExtra("ss6");
        ss7 = getIntent().getStringExtra("ss7");
        ss8 = getIntent().getStringExtra("ss8");
        ss9 = getIntent().getStringExtra("ss9");
        ss10 = getIntent().getStringExtra("ss10");
        ss11 = getIntent().getStringExtra("ss11");
        ss12 = getIntent().getStringExtra("ss12");
        ss13 = getIntent().getStringExtra("ss13");
        ss14 = getIntent().getStringExtra("ss14");
        ss15 = getIntent().getStringExtra("ss15");
        ss16 = getIntent().getStringExtra("ss16");
        ss17 = getIntent().getStringExtra("ss17");
        ss18 = getIntent().getStringExtra("ss18");
        ss19 = getIntent().getStringExtra("ss19");
        ss20 = getIntent().getStringExtra("ss20");
        ss21 = getIntent().getStringExtra("ss21");
        ss22 = getIntent().getStringExtra("ss22");
        ss23 = getIntent().getStringExtra("ss23");
        ss24 = getIntent().getStringExtra("ss24");
        ss25 = getIntent().getStringExtra("ss25");
        ss26 = getIntent().getStringExtra("ss26");

       seatsfun();

       seatno1.setText(seatsname.toUpperCase());


       pay1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {



               if(!passengernamevalidate() |  !mobilevalidate() | !agevalidate() | !gendervalidate() | !addressvalidate())
              {
                 return;
               }
              else {

               passengername2 = pass1.getText().toString();
               mobile2 = mobile1.getText().toString();
               age2 = age1.getText().toString();
               gender2 = gender1.getText().toString();
               address2 = address1.getText().toString();




                   pro1.setVisibility(View.VISIBLE);
                   Intent pay = new Intent(ticketing3.this, payment_original.class);

                   pay.putExtra("totalamount", c);
                   pay.putExtra("seatnumber", seatsname);
                   pay.putExtra("busname", busname2);
                   pay.putExtra("from1", from2);
                   pay.putExtra("to1", to2);
                   pay.putExtra("busid", busid);
                   pay.putExtra("remainingseats", ctotalseats);
                  // pay.putExtra("remainingseats", cremainingseats);
                   pay.putExtra("bookedseats", cbookedseats);
                   pay.putExtra("passengername", passengername2);
                   pay.putExtra("mobilenumber", mobile2);
                   pay.putExtra("age", age2);
                   pay.putExtra("address", address2);
                   pay.putExtra("gender", gender2);
                   pay.putExtra("busdate", busdate);
                   pay.putExtra("time", timing2);
                   pay.putExtra("date",date2);


                   pay.putExtra("s1", ss1);
                   pay.putExtra("s2", ss2);
                   pay.putExtra("s3", ss3);
                   pay.putExtra("s4", ss4);
                   pay.putExtra("s5", ss5);
                   pay.putExtra("s6", ss6);
                   pay.putExtra("s7", ss7);
                   pay.putExtra("s8", ss8);
                   pay.putExtra("s9", ss9);
                   pay.putExtra("s10", ss10);
                   pay.putExtra("s11", ss11);
                   pay.putExtra("s12", ss12);
                   pay.putExtra("s13", ss13);
                   pay.putExtra("s14", ss14);
                   pay.putExtra("s15", ss15);
                   pay.putExtra("s16", ss16);
                   pay.putExtra("s17", ss17);
                   pay.putExtra("s18", ss18);
                   pay.putExtra("s19", ss19);
                   pay.putExtra("s20", ss20);
                   pay.putExtra("s21", ss21);
                   pay.putExtra("s22", ss22);
                   pay.putExtra("s23", ss23);
                   pay.putExtra("s24", ss24);
                   pay.putExtra("s25", ss25);
                   pay.putExtra("s26", ss26);

                   pro1.setVisibility(View.GONE);
                   startActivity(pay);


               }
           }
       });





    }

    private boolean addressvalidate() {

        String val =address1.getText().toString();

        if(val.isEmpty()){
            address1.setError("Field cannot be empty");
            return false;
        }

        else
        {
            address1.setError(null);
            return true;
        }
    }


    private boolean agevalidate() {
        String val =age1.getText().toString();
        String i = "100";

        if(val.isEmpty()){
            age1.setError("Field cannot be empty");
            return false;
        }

        else
        {
            age1.setError(null);
            return true;
        }



    }
    private boolean gendervalidate(){

        String val =gender1.getText().toString();


        if(val.isEmpty()){
            gender1.setError("Field cannot be empty");
            return false;
        }

        else
        {
            gender1.setError(null);
            return true;
        }
    }



    private boolean mobilevalidate() {
        String val =mobile1.getText().toString();

        if(val.isEmpty()){
            mobile1.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()==9)
        {

            mobile1.setError(null);
            return true;

        }
        else
        {
            mobile1.setError("Mobile number must be 10 digits");
            return  false;
        }
    }

    private boolean passengernamevalidate() {

        String val =pass1.getText().toString();

        if(val.isEmpty()){
            pass1.setError("Field cannot be empty");
            return false;
        }

        else
        {
            pass1.setError(null);
            return true;
        }
    }



    private void seatsfun() {
        String m1 = "s1",m2= "s2",m3="s3",m4="s4",m5="s5", m6 = "s6",m7= "s7",m8="s8",
                m9="s9",m10="s10", m11 = "s11",m12= "s12",m13="s13",m14="s14"
                ,m15="s15", m16 = "s16",m17= "s17",m18="s18",m19="s19",m20="s20",
                m21 = "s21",m22= "s22",m23="s23",m24="s24",m25="s25",m26="s26";

        if(s1.matches(m1))
        {
             seatsname = " " + s1;
        }

        if(s2.matches(m2))
        {
            seatsname = seatsname + " " + s2;
        }

        if(s3.matches(m3))
        {
            seatsname = seatsname + " " + s3;
        }
        if(s4.matches(m4))
        {
            seatsname = seatsname + " " + s4;
        }

        if(s5.matches(m5))
        {
            seatsname = seatsname + " " + s5;
        }

        if(s6.matches(m6))
        {
            seatsname = seatsname + " " + s6;
        }

        if(s7.matches(m7))
        {
            seatsname = seatsname + " " + s7;
        }
        if(s8.matches(m8))
        {
            seatsname = seatsname + " " + s8;
        }


        if(s9.matches(m9))
        {
            seatsname =seatsname + " " + s9;
        }

        if(s10.matches(m10))
        {
            seatsname = seatsname + " " + s10;
        }

        if(s11.matches(m11))
        {
            seatsname = seatsname + " " + s11;
        }
        if(s12.matches(m12))
        {
            seatsname = seatsname + " " + s12;
        }


        if(s13.matches(m13))
        {
            seatsname =seatsname + " " +  s13;
        }

        if(s14.matches(m14))
        {
            seatsname = seatsname + " " + s14;
        }

        if(s15.matches(m15))
        {
            seatsname = seatsname + " " + s15;
        }
        if(s16.matches(m16))
        {
            seatsname = seatsname + " " + s16;
        }



        if(s17.matches(m17))
        {
            seatsname =seatsname + " " +  s17;
        }

        if(s18.matches(m18))
        {
            seatsname = seatsname + " " + s18;
        }

        if(s19.matches(m19))
        {
            seatsname = seatsname + " " + s19;
        }
        if(s20.matches(m20))
        {
            seatsname = seatsname + " " + s20;
        }


        if(s21.matches(m21))
        {
            seatsname =seatsname + " " +  s21;
        }

        if(s22.matches(m22))
        {
            seatsname = seatsname + " " + s22;
        }

        if(s23.matches(m23))
        {
            seatsname = seatsname + " " + s23;
        }
        if(s24.matches(m24))
        {
            seatsname = seatsname + " " + s24;
        }
        if(s25.matches(m25))
        {
            seatsname = seatsname + " " + s25;
        }
        if(s25.matches(m26))
        {
            seatsname = seatsname + " " + s25;
        }







    }
}

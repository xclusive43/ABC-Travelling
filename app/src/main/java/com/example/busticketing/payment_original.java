package com.example.busticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment_original extends AppCompatActivity {

    EditText amount,name,cardnumber,expiredate,cvv;
    CheckBox debit,credit;
    Button paymentbtn;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar1;

    String remainingseats,bookedseats,totalseats = "26",busfare1="450";
    String i="0";

    String cardnumber1,cardtype,name1,seatsname,tickekid,age,mobile,gender,address,busname,from,to,date,time,busfare,busid,date1;
    String  s1 ,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13 ,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_original);

        debit = findViewById(R.id.debitcard);
        progressBar1 = findViewById(R.id.progressbar1);
        credit = findViewById(R.id.creditcard);
        paymentbtn = findViewById(R.id.payment);
        amount = findViewById(R.id.amount);
        name = findViewById(R.id.accountname);
        cardnumber = findViewById(R.id.cardnumber);
        expiredate = findViewById(R.id.expdate);

        cvv = findViewById(R.id.cvv);

        amount.setText("Rs."+getIntent().getStringExtra("totalamount")+"/-");

        busfare = getIntent().getStringExtra("totalamount");
        seatsname = getIntent().getStringExtra("seatnumber");
        busname = getIntent().getStringExtra("busname");
        from = getIntent().getStringExtra("from1");
        to = getIntent().getStringExtra("to1");
        busid = getIntent().getStringExtra("busid");
        name1 = getIntent().getStringExtra("passengername");
        gender = getIntent().getStringExtra("gender");
        age = getIntent().getStringExtra("age");
        mobile = getIntent().getStringExtra("mobilenumber");
        address = getIntent().getStringExtra("address");
        date = getIntent().getStringExtra("busdate");
        date1 = getIntent().getStringExtra("date");
        time = getIntent().getStringExtra("time");
        remainingseats = getIntent().getStringExtra("remainingseats");
        bookedseats = getIntent().getStringExtra("bookedseats");




        //seats for updateing in database eg s1 = 1 or s1 =0 getting for previous activity
        s1 =  getIntent().getStringExtra("s1");
        s2 =  getIntent().getStringExtra("s2");
        s3 =  getIntent().getStringExtra("s3");
        s4 =  getIntent().getStringExtra("s4");
        s5 =  getIntent().getStringExtra("s5");
        s6 =  getIntent().getStringExtra("s6");
        s7 =  getIntent().getStringExtra("s7");
        s8 =  getIntent().getStringExtra("s8");
        s9 =  getIntent().getStringExtra("s9");
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








        firebaseAuth = FirebaseAuth.getInstance();

        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!namevalidate() | !cardnumbervalidate() | !datevalidate() | !cvvvalidate()) {
                    return;
                }

                else
                    {   progressBar1.setVisibility(View.VISIBLE);
                        generaterandom();


                        cardnumber1 = cardnumber.getText().toString();//card number input

                        if (credit.isChecked()) { //card input
                            cardtype = "credit card";
                            debit.setEnabled(false);
                        } else if(debit.isChecked())
                        {
                            cardtype = "debit card";
                            credit.setEnabled(false);
                        }
                        updatedatainbus();
                        insertintoalltickets();
                        getpaymentdetails();




                        progressBar1.setVisibility(View.GONE);
                        Intent intent13 = new Intent(payment_original.this,ticketing.class);
                        Toast.makeText(payment_original.this,"Transcation Successfull",Toast.LENGTH_LONG).show();
                        intent13.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent13.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent13);
                        finish();

                    }

            }
        });
    }

    private void insertintoalltickets() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref1 = firebaseDatabase.getReference("all_tickets");

        getandsetpayment data2 = new getandsetpayment(cardnumber1,cardtype,name1,seatsname,tickekid,age,mobile,gender,address,busname,from,to,date1,time,busfare);

        myref1.child(tickekid).setValue(data2);


    }

    private void updatedatainbus() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("busdetails").child(busid).child(from).child(to).child("dates").child(date);
        seatsupdate data1 = new seatsupdate(remainingseats,bookedseats,totalseats,busfare1,time, s1 ,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26);

        databaseReference.setValue(data1);




        //


    }

    private void getpaymentdetails() {





        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref1 = firebaseDatabase.getReference("tickets_bookings");


       // getandsetpayment data2 = new getandsetpayment(cardnumber1,cardtype,name1,seatsname,tickekid,age,mobile,gender,address,busname,from,to,date,time,busfare);

        myref1.child(firebaseAuth.getUid()).child("b1").setValue(tickekid);


    }

    private void generaterandom() {

        randomnumbers randomnumbers = new randomnumbers();

        tickekid = randomnumbers.generatealphanumeric(10);
    }

    private boolean cvvvalidate() {

        String val = cvv.getText().toString();

        if(val.isEmpty())
        {
            cvv.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()==3)
        {
            cvv.setError(null);
            return  true;
        }
        else
        {
            cardnumber.setError("cvv must be 3 digits");

            return  false;
        }
    }

    private boolean namevalidate() {

        String val =name.getText().toString();

        if(val.isEmpty()){
            name.setError("Field cannot be empty");
            return false;
        }

        else
        {
            name.setError(null);


            return true;
        }
    }


    private boolean cardnumbervalidate()  {
        String val =cardnumber.getText().toString();


        if(val.isEmpty()){
            cardnumber.setError("Field cannot be empty");

            return false;
        }
        else if(val.length() == 16)
        {

            cardnumber.setError(null);

            return true;

        }
        else
        {
            cardnumber.setError("card-number must be 16 digits");

            return  false;

        }



    }
    private boolean datevalidate(){

        String val =expiredate.getText().toString();


        if(val.isEmpty()){
            expiredate.setError("Field cannot be empty");
            return false;
        }

        else
        {
            expiredate.setError(null);


            return true;
        }
    }


}


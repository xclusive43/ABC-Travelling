package com.example.busticketing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
 private  static  int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(firebaseUser != null)
                    {
                        startActivity(new Intent(MainActivity.this,index.class));
                        finish();
                    }
                    else{
                        Intent homeIntent = new Intent(MainActivity.this , newregister.class);
                        startActivity(homeIntent);
                        finish();
                    }

                }
            }, SPLASH_TIME_OUT);
        }
    }


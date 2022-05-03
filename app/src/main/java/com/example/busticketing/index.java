package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class index extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    MenuItem logout;
    Button book1,book2,book3,book4;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

     final
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        drawerLayout =findViewById(R.id.drawer_layout1);
        navigationView = findViewById(R.id.nav1);
        toolbar =findViewById(R.id.toolbar1);

         book1 =  findViewById(R.id.book1);
         book2 =  findViewById(R.id.book2);
         book3 =  findViewById(R.id.book3);
         book4 =  findViewById(R.id.book4);

        logout =  findViewById(R.id.nav_logout);

         firebaseAuth = FirebaseAuth.getInstance();
         firebaseUser =  firebaseAuth.getCurrentUser();

        // mail1.setText(firebaseUser.getEmail());

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = "RIA";
                String val1 = "ria1";

                Intent intent1= new Intent(index.this,ticketing.class);
                intent1.putExtra("val",val);
                intent1.putExtra("val1",val1);
                startActivity(intent1);
            }
        });

         book2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String val = "ASHIRBAD";
                 String val1 = "ashirbad1";

                 Intent intent1= new Intent(index.this,ticketing.class);
                 intent1.putExtra("val",val);
                 intent1.putExtra("val1",val1);
                 startActivity(intent1);
             }
         });

         book3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String val = "NETWORK";
                 String val1 = "network1";

                 Intent intent1= new Intent(index.this,ticketing.class);
                 intent1.putExtra("val",val);
                 intent1.putExtra("val1",val1);
                 startActivity(intent1);
             }
         });

         book4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String val = "MILLENNIUM";
                 String val1= "millennium1";

                 Intent intent1= new Intent(index.this,ticketing.class);
                 intent1.putExtra("val",val);
                 intent1.putExtra("val1",val1);
                 startActivity(intent1);
             }
         });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.draweropen,R.string.drawerclose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
     }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            {
                super.onBackPressed();
            }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_mybookings:
                Intent intent =new Intent(index.this,mybooking.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:

                FirebaseAuth.getInstance().signOut();
                Intent intent1= new Intent(index.this, newregister.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
                finish();

                break;

            case R.id.nav_profile:
                Intent intent2 =new Intent(index.this,profile.class);
                startActivity(intent2);
                break;

            case R.id.nav_contact:
                Intent intent8 =new Intent(index.this,contactus.class);
                startActivity(intent8);
                break;
            case R.id.nav_feedback:
                Intent intent3 =new Intent(index.this,feedback.class);
               startActivity(intent3);
                break;
        }
        return true;
    }
}

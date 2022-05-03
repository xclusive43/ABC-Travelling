package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView name,age,mobile,address,email,gender;
    Button update;

    ProgressBar progressBar1;
   private   FirebaseAuth firebaseAuth;
   private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.nametext);
        age= findViewById(R.id.agetext);
        mobile = findViewById(R.id.mobiletext);
        email= findViewById(R.id.emailtext);
        address = findViewById(R.id.addresstext);
        gender= findViewById(R.id.gendertext);
        progressBar1 = findViewById(R.id.profilebar);
        progressBar1.setVisibility(View.VISIBLE);

        update = findViewById(R.id.update);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        DatabaseReference databaseReference = firebaseDatabase.getReference("users").child(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 getandsetprofile getandsetprofile1 = dataSnapshot.getValue(getandsetprofile.class);

                 name.setText(getandsetprofile1.name);
                 age.setText(getandsetprofile1.age);
                 email.setText(getandsetprofile1.email);
                 mobile.setText(getandsetprofile1.mobile);
                 address.setText(getandsetprofile1.address);
                 gender.setText(getandsetprofile1.gender);

                 progressBar1.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(profile.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                progressBar1.setVisibility(View.GONE);
            }
        });




    }
}

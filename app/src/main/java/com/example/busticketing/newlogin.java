package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class newlogin extends AppCompatActivity {

    ProgressBar progressBar;
    Button loginbtn,backsignin;
    EditText email,password;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlogin);

        progressBar = findViewById(R.id.progress2);
        email = findViewById(R.id.emaillogin);
        password = findViewById(R.id.passwordlogin);
        loginbtn = findViewById(R.id.loginbtn);
        backsignin = findViewById(R.id.backsignin);

firebaseAuth = FirebaseAuth.getInstance();

loginbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(!validateemail() | !validatepassword())
        {
            return;
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {   progressBar.setVisibility(View.GONE);
                        email.setText("");
                        password.setText("");
                        startActivity( new Intent(newlogin.this, index.class));
                        finish();
                    }
                    else
                    {   progressBar.setVisibility(View.GONE);
                        email.setText("");
                        password.setText("");
                        Toast.makeText(newlogin.this,"login fails",Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }
});

backsignin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(newlogin.this,newregister.class));
    }
});


    }
    private boolean validateemail()
    {
        String val =email.getText().toString();

        if(val.isEmpty()){
            email.setError("Field cannot be empty");
            return false;
        }

        else
        {
           email.setError(null);
           email.setEnabled(false);

            return true;
        }

    }
    private boolean validatepassword()
    {
        String val =password.getText().toString();


        if(val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }

        else
        {
            password.setError(null);
            password.setEnabled(false);

            return true;
        }

    }

}

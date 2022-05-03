package com.example.busticketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newregister extends AppCompatActivity {

    Button btn,login;
    ProgressBar progressBar;
    EditText email,password,fullname,mobilenumber,address,cpassword,age;
    RadioButton male,female;
    FirebaseAuth firebaseAuth;


    String fname1,moblie1,email1,address1,password1,gender="",age1; //string deleceration as global
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newregister);


        btn = findViewById(R.id.btn1);
        login = findViewById(R.id.login1);
        progressBar = findViewById(R.id.progress1);
        fullname = findViewById(R.id.name);
        mobilenumber = findViewById(R.id.phonenumber);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpass);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        firebaseAuth = FirebaseAuth.getInstance();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!validatename() | !validateemail() | !validatemobile() | !validatecpass() | !validatepass() | !validateaddress() | !validateage())
                {
                   return;
                }
               else{
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);

                            if(task.isSuccessful())
                            {    progressBar.setVisibility(View.GONE);

                                loaddata();

                                Toast.makeText(newregister.this,"register successfull",Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(newregister.this,newlogin.class);

                                intent2.putExtra("email",email.getText().toString());
                                intent2.putExtra("password",password.getText().toString());

                                startActivity(intent2);

                                email.setText("");
                                password.setText("");
                                cpassword.setText("");
                                fullname.setText("");
                                address.setText("");
                                mobilenumber.setText("");
                                finish();


                            }
                            else
                            {   progressBar.setVisibility(View.GONE);
                                email.setText("");
                                password.setText("");
                                fullname.setText("");
                                address.setText("");
                                mobilenumber.setText("");
                                age.setText("");
                                cpassword.setText("");
                                Toast.makeText(newregister.this,"Registration Failed!",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(getIntent());

                            }
                        }
                    });
                }

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(newregister.this,newlogin.class);
                startActivity(intent1);
            }
        });
    }



    private  void loaddata()
    {

        fname1 = fullname.getText().toString();
        email1 = email.getText().toString();
        moblie1 =mobilenumber.getText().toString();
        password1 = password.getText().toString();
        address1 =address.getText().toString();
        age1 = age.getText().toString();

        if (male.isChecked()) {
            gender = "male";
        } else if(female.isChecked())
        {
            gender = "female";
        }

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("users");
        newregisterclass data1 = new newregisterclass(fname1,email1,moblie1,password1,gender,address1,age1);
        myref.child(firebaseAuth.getUid()).setValue(data1);
    }


    private boolean validatename()
    {
        String val =fullname.getText().toString();

        if(val.isEmpty()){
            fullname.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()>=20 || val.length() < 2)
        {
            fullname.setError("name cannot be more than 20 letters!");
            fullname.setText("");
            return false;
        }
        else
        {
            fullname.setError(null);
            fullname.setEnabled(false);

            return true;
        }

    }
    private boolean validateage()
    {
        String val =age.getText().toString();
        String i = "100";

        if(val.isEmpty()){
           age.setError("Field cannot be empty");
            return false;
        }

        else
        {
           age.setError(null);
           age.setEnabled(false);

            return true;
        }

    }

    private boolean validateaddress()
    {
        String val =address.getText().toString();

        if(val.isEmpty()){
            address.setError("Field cannot be empty");
            return false;
        }
        else if(val.length()>=80 || val.length() < 3)
        {
            address.setError("address cannot be more than 80 letters!");
            address.setText("");

            return false;
        }
        else
        {
            address.setError(null);
            address.setEnabled(false);

            return true;
        }

    }
    private boolean validateemail()
    {
        String val =email.getText().toString();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            email.setError("Field cannot be empty");

            return false;
        }
        else if(!val.matches(emailpattern))
        {
            email.setError("Invalid email address");
            email.setText("");
            return false;
        }
        else
        {
            email.setError(null);
            email.setEnabled(false);
            return true;
        }

    }
    private boolean validatemobile()
    {
        String val =mobilenumber.getText().toString();

        if(val.isEmpty()){
            mobilenumber.setError("Field cannot be empty");

            return false;
        }
        else if(val.length()>11 | val.length()<9)
        {
            mobilenumber.setError("Mobile number must be 10 digits");
            mobilenumber.setText("");
            return  false;
        }
        else
        {
            mobilenumber.setError(null);
            mobilenumber.setEnabled(false);
            return true;
        }

    }

   private boolean validatepass()
    {
        String val =password.getText().toString();
        String passpattern ="^" +
                "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$";

        if(val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }
        else if (!val.matches(passpattern))
        {
            password.setError("Field should contain at least one symbol ,character ,upper and lower case letters ");
            password.setText("");
            return false;
        }

        else
        {
            password.setError(null);
            password.setEnabled(false);

            return true;
        }

    }
    private boolean validatecpass()
    {
        String val =cpassword.getText().toString();
        String val1 =cpassword.getText().toString();

        if(val.isEmpty()){
            cpassword.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(val1))
        {
            cpassword.setError("password  not matched!");
            cpassword.setText("");
            return false;


        }
        else
        {
            cpassword.setError(null);
            cpassword.setEnabled(false);

            return true;
        }

    }

}

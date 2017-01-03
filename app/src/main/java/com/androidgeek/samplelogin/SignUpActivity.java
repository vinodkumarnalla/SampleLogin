package com.androidgeek.samplelogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button signup;
    EditText input_name,input_email,input_mobile,input_password,input_reEnterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup= (Button) findViewById(R.id.btn_signup);
        input_name= (EditText) findViewById(R.id.input_name);
        input_email= (EditText) findViewById(R.id.input_email);
        input_mobile= (EditText) findViewById(R.id.input_mobile);
        input_password= (EditText) findViewById(R.id.input_password);
        input_reEnterPassword= (EditText) findViewById(R.id.input_reEnterPassword);
        signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
       if(input_name.getText().length()<=0)
       {
           input_name.setError("Please enter your name");
           input_name.requestFocus();
       }else if(!(input_email.getText().length()<=0||isEmailValid(input_email.getText().toString()))){
           input_email.setError(getString(R.string.error_invalid_email));
           input_email.requestFocus();
       }
       else if(input_mobile.getText().length()<=0){
           input_mobile.setError("Please enter your mobile number");
           input_mobile.requestFocus();
       }
       else if(input_password.getText().length()<0){
           input_password.setError("Please enter a password");
           input_password.requestFocus();
       }
       else if(input_reEnterPassword.getText().length()<0){
           input_reEnterPassword.setError("Please re-enter your password");
           input_reEnterPassword.requestFocus();
       }
       else if(!(input_reEnterPassword.getText().toString().equals(input_password.getText().toString()))){
           input_reEnterPassword.setError("Passwords are not matching");
           input_reEnterPassword.requestFocus();
       }
        else{
           Snackbar.make(v,"Account created sucessfully",Snackbar.LENGTH_LONG).show();
       }
    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        if (email == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
}

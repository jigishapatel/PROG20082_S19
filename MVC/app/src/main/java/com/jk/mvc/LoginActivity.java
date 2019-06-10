package com.jk.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//controller
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail;
    EditText edtPassword;
    Button btnSignUp;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.referWidgets();
    }

    private void referWidgets(){
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        btnSignIn = findViewById(R.id.btn_signin);
        btnSignIn.setOnClickListener(this);

        btnSignUp = findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                //signin
                this.doSignIn();
                break;
            case R.id.btn_signup:
                //signup
                this.doSignUp();
                break;
        }
    }

    private void doSignIn(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

    }

    private void doSignUp(){
        //open next screen for signup
        Intent signupIntent = new Intent(this, SignUpActivity.class);
        startActivity(signupIntent);
    }

}

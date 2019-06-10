package com.jk.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String password;
    String gender;
    EditText edtFname;
    EditText edtLname;
    EditText edtPhone;
    EditText edtEmail;
    EditText edtPswd;
    EditText edtConfirm;
    RadioGroup rdoGender;
    RadioButton rdoSelected;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.referWidgets();
    }

    private void referWidgets(){
        edtFname = findViewById(R.id.edt_firstname);
        edtLname = findViewById(R.id.edt_lastname);
        edtPhone = findViewById(R.id.edt_phone);
        edtEmail = findViewById(R.id.edt_email);
        edtPswd = findViewById(R.id.edt_password);
        edtConfirm = findViewById(R.id.edt_confirm_password);

        rdoGender = findViewById(R.id.rdo_gender);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                //submit
                break;
        }
    }

    private void getValues(){
        firstName = edtFname.getText().toString();
        lastName = edtLname.getText().toString();
        phoneNumber = edtPhone.getText().toString();
        email = edtEmail.getText().toString();
        password = edtPswd.getText().toString();
        rdoSelected = findViewById(rdoGender.getCheckedRadioButtonId());
        gender = rdoSelected.getText().toString();
    }
}

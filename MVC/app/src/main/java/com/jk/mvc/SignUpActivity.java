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

import com.jk.mvc.controller.UserController;
import com.jk.mvc.model.User;

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

    User newUser;
    //create the instance of controller
    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        this.referWidgets();
        userController = new UserController();
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
                if (this.validateData()){
                    this.getValues();

                    //load data to the model object
                    newUser = new User(firstName, lastName, phoneNumber,
                            gender, email, password);
                    Log.d("signUpActivity", newUser.toString());
                    userController.insertUser(newUser);

                    Intent mainIntent = new Intent(this, MainActivity.class);
                    mainIntent.putExtra("EXTRA_EMAIL", email);
                    startActivity(mainIntent);
                }
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

    /** method to validate the entered data for teh required constraints
     */
    private boolean validateData(){
        boolean allValidations = true;

        if (edtFname.getText().toString().isEmpty()){
            edtFname.setError("You must enter first name");
            allValidations = false;
        }

        if (edtLname.getText().toString().isEmpty()){
            edtLname.setError("You must enter last name");
            allValidations = false;
        }

        if (edtPhone.getText().toString().isEmpty()){
            edtPhone.setError("You must provide phone number");
            allValidations = false;
        }

        if (edtEmail.getText().toString().isEmpty()){
            edtEmail.setError("Email cannot be empty");
            allValidations = false;
        }else if (!Utils.isValidEmail(edtEmail.getText().toString())){
            edtEmail.setError("Please provide valid email address");
            allValidations = false;
        }

        if (edtPswd.getText().toString().isEmpty()){
            edtPswd.setError("Please enter password");
            allValidations = false;
        }

        if (edtConfirm.getText().toString().isEmpty()){
            edtConfirm.setError("You must enter confirm password");
            allValidations = false;
        }else if (!edtPswd.getText().toString().equals(edtConfirm.getText().toString())){
            edtConfirm.setError("Both passwords must be same");
            allValidations = false;
        }

        return allValidations;
    }
}















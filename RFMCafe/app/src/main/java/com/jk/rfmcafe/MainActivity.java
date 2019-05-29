package com.jk.rfmcafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCancel;
    Button btnSubmit;

    RadioGroup rdoCoffee;
    RadioButton rdoSelected;

    CheckBox chkDom;
    CheckBox chkEspresso;
    CheckBox chkSleeve;
    CheckBox chkWhipped;

    Spinner spnCream;
    Spinner spnSugar;

    EditText edtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI Views
        this.referWidgets();
    }

    private void referWidgets(){
        edtName = findViewById(R.id.edt_name);

        rdoCoffee = findViewById(R.id.rdo_coffee);

        chkDom = findViewById(R.id.chk_dom);
        chkEspresso = findViewById(R.id.chk_espresso);
        chkSleeve = findViewById(R.id.chk_sleeve);
        chkWhipped = findViewById(R.id.chk_whipped);

        spnCream = findViewById(R.id.spn_cream);
        spnSugar = findViewById(R.id.spn_sugar);

        ArrayAdapter<CharSequence> numberAdapter =
                ArrayAdapter.createFromResource(this, R.array.number_array,
                        android.R.layout.simple_spinner_dropdown_item);
        spnCream.setAdapter(numberAdapter);
        spnSugar.setAdapter( numberAdapter);

        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel:
                Log.d("MainActivity", "Cancel Clicked");
                this.finishAffinity();
                break;
            case R.id.btn_submit:
                Log.d("MainActivity", "Submit Clicked");
                this.getValues();
                break;
        }
    }

    private void getValues(){

        String name = edtName.getText().toString();

        rdoSelected = findViewById(rdoCoffee.getCheckedRadioButtonId());
        String coffee = rdoSelected.getText().toString();

        String addOn = "";
        if (chkWhipped.isChecked()){
            addOn += " Whipped Cream";
        }

        if (chkEspresso.isChecked()){
            addOn += " Espresso Shot";
        }

        if (chkSleeve.isChecked()){
            addOn += " Sleeve";
        }

        if (chkDom.isChecked()){
            addOn += " Dom lid";
        }

        String cream = spnCream.getSelectedItem().toString() + " cream ";
        String sugar = spnSugar.getSelectedItem().toString() + " sugar ";

        String output = "Hey " + name + " ! Thank you for your order of " +
                coffee + " " + cream + sugar + " with" + addOn;
        Log.d("MainActivity", output);
        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();
    }
}

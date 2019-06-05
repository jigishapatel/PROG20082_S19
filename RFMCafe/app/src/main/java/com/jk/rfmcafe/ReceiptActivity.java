package com.jk.rfmcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiptActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOrderDetails;
    TextView tvOrderAmount;
    Button btnDone;
    Button btnAnotherOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        this.referWidgets();
        this.fetchExtras();
    }

    private void referWidgets(){
        tvOrderAmount = findViewById(R.id.tv_amount);
        tvOrderDetails = findViewById(R.id.tv_order);

        btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);

        btnAnotherOrder = findViewById(R.id.btn_another_order);
        btnAnotherOrder.setOnClickListener(this);

    }

    private void fetchExtras(){
        Intent currentIntent = this.getIntent();
        //receiving data from previous activity
        String output = currentIntent.getStringExtra("EXTRA_OUTPUT");
        tvOrderDetails.setText(output);

        Double amount = currentIntent.getDoubleExtra("EXTRA_AMOUNT", 0.0);
        tvOrderAmount.setText("$" + amount.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                //terminate app
                finishAffinity();
                break;
            case R.id.btn_another_order:
                //terminate Activity
                this.finish();
                break;
        }
    }
}

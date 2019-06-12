package com.jk.mvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jk.mvc.controller.UserController;
import com.jk.mvc.model.User;

public class MainActivity extends AppCompatActivity {

    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userController = new UserController();

        this.fetchUserInfo();

    }

    private void fetchUserInfo(){
        Intent thisIntent = this.getIntent();
        String email = thisIntent.getStringExtra("EXTRA_EMAIL");

        User currentUser = userController.fetchUserByEmail(email);

        if (currentUser != null) {
            Log.d("MainActivity", currentUser.toString());
            Log.d("MainActivity", "Firstname : " + currentUser.getFirstName());
        }
    }
}

package com.jk.mvc.controller;

import com.jk.mvc.UserSingleton;
import com.jk.mvc.model.User;

import java.util.ArrayList;

/**
 * Created by Jigisha Patel on 2019-06-12.
 */
public class UserController {
    public void insertUser(User newUser){
        UserSingleton.getInstance().addUser(newUser);
    }

    public User fetchUserByEmail(String email){
        return UserSingleton.getInstance().getUserByEmail(email);
    }

    public ArrayList<User> fetchAllUsers(){
        return UserSingleton.getInstance().getUserList();
    }

    public boolean validateUser(String email, String password){
        return UserSingleton.getInstance().validateUser(email, password);
    }
}

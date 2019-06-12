package com.jk.mvc;

import android.util.Log;

import com.jk.mvc.model.User;

import java.util.ArrayList;

/**
 * Created by Jigisha Patel on 2019-06-12.
 */
public class UserSingleton {
    //lazy initialization
    private static UserSingleton userSingleton;

    //list of users
    private ArrayList<User> userList;

    //method with same name as class to
    // initialize ArrayList only once when
    // the very first object of the class is created
    private UserSingleton(){
        userList = new ArrayList<User>();
    }

    //returns a single and same instance of UserSingleton class always
    public static UserSingleton getInstance(){
        if (userSingleton == null) {
            userSingleton = new UserSingleton();
        }

        return userSingleton;
    }

    //method to add new user into the ArrayList
    public void addUser(User newUser){
        userList.add(newUser);
        Log.d("UserSingleton", "New user added \n "
                + newUser.toString());
    }

    public User getUserByEmail(String email){
        for (User currentUser: userList){
            //checking if the current user object is
            //same as we are searching
            if (currentUser.getEmail().equals(email)){
                //user account found and returning object
                return currentUser;
            }
        }

        //user account does not exist
        return null;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public boolean validateUser(String email, String password){
        for (User currentUser : userList){
            //check if email and password are valid
            if (currentUser.getEmail().equals(email) &&
            currentUser.getPassword().equals(password)){
                //user found and is valid
                return true;
            }
        }

        //user does not found or invalid
        return false;
    }
}












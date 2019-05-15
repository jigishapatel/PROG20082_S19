package com.example.hellojava;

/**
 * Created by Jigisha Patel on 2019-05-15.
 */
public class Person {
    String firstName;
    String lastName;
    int age;

    //default constructor
    Person(){
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.age = 0;
    }

    //parameterized constructor
    Person(String fnm, String lnm, int age){
        this.firstName = fnm;
        this.lastName = lnm;
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        String data = "Firstname : " + this.firstName;
        data += "\nLastname : " + this.lastName;
        data += "\nAge : " + this.age;

        return data;
    }
}

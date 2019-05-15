package com.example.hellojava;

/**
 * Created by Jigisha Patel on 2019-05-15.
 */
public class PayCalc {
    public static void main(String []args){
        Person me = new Person();

        System.out.println(me.toString());

        me.setFirstName("JK");
        me.setLastName("LM");
        me.setAge(90);
        System.out.println(me.toString());

        Person you = new Person("Faaiz", "Rehan", 22);
        System.out.println(you.toString());

        Employee prof = new Employee();
        prof.setFirstName("Adem");
        prof.setLastName("Eve");
        prof.setAge(50);
        prof.setPay(20.50);
        System.out.println(prof.toString());

    }
}

/*Experiemnt:

Add type of employee (full-time or part-time)
Add data member to indicate the basic pay of employee
(basic pay for part-time is $20, full-time is $50)
Add a variable to represent the number of hours
    employee has worked.

Add a method to calculate the final Pay for
the employee considering the number of hours
they have worked and their status.
 */

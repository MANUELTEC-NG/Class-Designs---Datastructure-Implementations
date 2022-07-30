package com.manuel.decadev.contact;

import java.util.ArrayList;
import java.util.Date;

public class Contact {

    private String firstName = "";
    private String lastName = "";
    private String fullname ;
    private double phone = 123-456-789;
    private  StringBuilder contact;

    ArrayList dates = new ArrayList<>();
    public Contact(String firstName, String lastName, double phone) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        contact = new StringBuilder(30).append(firstName).append(lastName);
        fullname = contact.toString();
    }


    public Contact(){
        this.firstName = "John";
        this.lastName = "Doe";
    }


    public boolean exist(String name){

        return false;
    }

    public void modifyFName(String firstName ){

    }
}


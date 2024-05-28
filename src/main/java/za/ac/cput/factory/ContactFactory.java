package za.ac.cput.factory;

import za.ac.cput.entity.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
    public static Contact buildContact(String email, String cellNumber){
        Long number = Long.valueOf(cellNumber);
        if(!Helper.isValidEmail(email) || Helper.isNullOrEmpty(cellNumber))
            return null;
        if(cellNumber.length() != 10)
            throw new IllegalArgumentException("Mobile number must be exactly 10 digits long");

        return new Contact.Builder().setEmail(email).setCellNumber(cellNumber).build();
    }
}

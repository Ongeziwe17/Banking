package za.ac.cput.factory;

import za.ac.cput.entity.Name;
import za.ac.cput.util.Helper;

public class NameFactory {
    public static Name buildName(String firstName, String lastName){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) return null;
        return new Name.Builder().setFirstName(firstName).setLastName(lastName).build();
    }
}

package za.ac.cput.factory;

import za.ac.cput.entity.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {
    public static Address buildAddress(int streetNumber, String streetName, String city, int postalCode){
        if(Helper.isNullOrEmpty(streetNumber) || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(postalCode)) return null;

        return new Address.Builder().setStreetNumber(streetNumber).setStreetName(streetName).setCity(city).setPostalCode(postalCode).build();
    }
}

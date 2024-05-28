package za.ac.cput.factory;

import za.ac.cput.entity.*;
import za.ac.cput.util.Helper;

import java.util.HashMap;

public class AccountHolderFactory {
    public static AccountHolder accountHolderFactory(long accountHolderId, Name name, Contact contact, Address address, Account account){
        if(Helper.isNullOrEmpty(accountHolderId) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(contact) || Helper.isNullOrEmpty(address) | Helper.isNullOrEmpty(account)) return null;
        return new AccountHolder.Builder().setAccountHolderId(accountHolderId).setName(name).setContact(contact).setAddress(address).setAccount(account).build();
    }
}

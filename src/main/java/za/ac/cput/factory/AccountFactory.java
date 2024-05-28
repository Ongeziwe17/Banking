package za.ac.cput.factory;

import za.ac.cput.entity.Account;
import za.ac.cput.entity.enums.AccountType;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AccountFactory {
    public static Account buildAccount(long accountId, AccountType accountType, LocalDateTime dateCreated, LocalDate expiryDate){
        if(Helper.isNullOrEmpty(accountId) || Helper.isNullOrEmpty(accountType) || Helper.isNullOrEmpty(dateCreated) || Helper.isNullOrEmpty(expiryDate)) return null;
        return new Account.Builder().setAccountId(accountId).setAccountType(accountType).setDateCreated(dateCreated).setExpiryDate(expiryDate).build();
    }
}

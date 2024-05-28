package za.ac.cput.service;

import za.ac.cput.entity.Account;

import java.util.Set;

public interface IAccountService extends IService<Account, Long>{
    Set<Account> getAll();
}

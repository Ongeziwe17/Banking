package za.ac.cput.service;

import za.ac.cput.entity.AccountHolder;

import java.util.Set;

public interface IAccountHolderService extends IService<AccountHolder,Long>{
    public AccountHolder delete(long accountHolderId);
    Set<AccountHolder> getAll();
}

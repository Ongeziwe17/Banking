package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.AccountHolder;
import za.ac.cput.repository.AccountHolderRepository;
import za.ac.cput.service.IAccountHolderService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountHolderServiceImpl implements IAccountHolderService {

    private final AccountHolderRepository repository;
    @Autowired
    public AccountHolderServiceImpl(AccountHolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccountHolder create(AccountHolder accountHolder) {  return repository.save(accountHolder); }

    @Override
    public AccountHolder read(Long accountHolderId) {
        return repository.findById(accountHolderId).orElseThrow();
    }

    @Override
    public AccountHolder update(AccountHolder accountHolder) {
        return repository.save(accountHolder);
    }

    @Override
    public AccountHolder delete(long accountHolderId) {
        AccountHolder accountHolderToDelete = read(accountHolderId);
        repository.delete(accountHolderToDelete);
        return accountHolderToDelete;
    }

    @Override
    public Set<AccountHolder> getAll() {
        return new HashSet<>(repository.findAll());
    }
}

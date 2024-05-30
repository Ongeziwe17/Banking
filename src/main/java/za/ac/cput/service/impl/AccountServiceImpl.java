package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Account;
import za.ac.cput.repository.AccountRepository;
import za.ac.cput.service.IAccountService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository repository;
    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account create(Account account) {
        return repository.save(account);
    }

    @Override
    public Account read(Long accountId) {
        return repository.findById(accountId).orElseThrow();
    }

    @Override
    public Account update(Account account) {
        return repository.save(account);
    }

    @Override
    public Set<Account> getAll() {
        return new HashSet<>(repository.findAll());
    }
}

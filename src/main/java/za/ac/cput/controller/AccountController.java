package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Account;
import za.ac.cput.service.impl.AccountServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountServiceImpl accountService;
    @Autowired
    public AccountController(AccountServiceImpl accountService) { this.accountService = accountService; }
    @PostMapping("/create")
    public Account create(@RequestBody Account account){ return accountService.create(account); }
    @GetMapping("/read/{accountNumber}")
    public Account read(@PathVariable long accountNumber){ return accountService.read(accountNumber); }
    @PutMapping("/update")
    public Account update(@RequestBody Account account){ return accountService.update(account); }
    @GetMapping("/getallaccounts")
    public Set<Account> getAll(){ return accountService.getAll(); }
}

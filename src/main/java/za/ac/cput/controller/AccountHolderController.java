package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.AccountHolder;
import za.ac.cput.service.impl.AccountHolderServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/accountholders")
public class AccountHolderController {
    private final AccountHolderServiceImpl accountHolderService;
    @Autowired
    public AccountHolderController(AccountHolderServiceImpl accountHolderService) { this.accountHolderService = accountHolderService; }
    @PostMapping("/create")
    public AccountHolder create(@RequestBody AccountHolder accountHolder){ return accountHolderService.create(accountHolder); }
    @GetMapping("/read/{accountHolderId}")
    public AccountHolder read(@PathVariable long accountHolderId){ return accountHolderService.read(accountHolderId); }
    @PostMapping("/update")
    public AccountHolder update(@RequestBody AccountHolder accountHolder){ return accountHolderService.update(accountHolder); }
    @DeleteMapping("/delete/{accountHolderId}")
    public AccountHolder delete(@PathVariable long accountHolderId, @RequestBody AccountHolder accountHolder){ return accountHolderService.delete(accountHolderId); }
    @GetMapping("/getallaccountholders")
    public Set<AccountHolder> getAll(){ return accountHolderService.getAll(); }
}

package com.mouakkal.bank_account_service.web;

import com.mouakkal.bank_account_service.dto.BankAccountRequestDTO;
import com.mouakkal.bank_account_service.dto.BankAccountResponseDTO;
import com.mouakkal.bank_account_service.entities.BankAccount;
import com.mouakkal.bank_account_service.mappers.AccountMapper;
import com.mouakkal.bank_account_service.repositories.BankAccountRepository;
import com.mouakkal.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BandCombineOp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController @RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    public AccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account= bankAccountRepository.findById(id).orElseThrow();
        if(account.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        account.setBalance(bankAccount.getBalance());
        if(account.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(account.getType()!=null)account.setType(bankAccount.getType());
        if(account.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}

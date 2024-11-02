package com.mouakkal.bank_account_service.service;

import com.mouakkal.bank_account_service.dto.BankAccountRequestDTO;
import com.mouakkal.bank_account_service.dto.BankAccountResponseDTO;
import com.mouakkal.bank_account_service.entities.BankAccount;
import com.mouakkal.bank_account_service.mappers.AccountMapper;
import com.mouakkal.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Transactional @Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    @Override
    public  BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO){
       BankAccount bankAccount= BankAccount.builder()
               .id(UUID.randomUUID().toString())
               .createdAt(new Date())
               .balance(bankAccountDTO.getBalance())
               .type(bankAccountDTO.getType())
               .currency(bankAccountDTO.getCurrency())
               .build();
       BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
       BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
       return bankAccountResponseDTO;
    }
}

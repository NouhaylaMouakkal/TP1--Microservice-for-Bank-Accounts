package com.mouakkal.bank_account_service.web;

import com.mouakkal.bank_account_service.dto.BankAccountRequestDTO;
import com.mouakkal.bank_account_service.dto.BankAccountResponseDTO;
import com.mouakkal.bank_account_service.entities.BankAccount;
import com.mouakkal.bank_account_service.entities.Customer;
import com.mouakkal.bank_account_service.repositories.BankAccountRepository;
import com.mouakkal.bank_account_service.repositories.CustomerRepository;
import com.mouakkal.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id ,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        bankAccountRepository.deleteById(id);
        return true;
    }
    public List<Customer> customers(){
        return customerRepository.findAll();
    }
}
//record BankAccountDTO(Double balance , String type , String currency ){
//}
package com.mouakkal.bank_account_service.service;

import com.mouakkal.bank_account_service.dto.BankAccountRequestDTO;
import com.mouakkal.bank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

     BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);

     void deleteAccount(String id);
}

package com.mouakkal.bank_account_service.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mouakkal.bank_account_service.dto.BankAccountResponseDTO;
import com.mouakkal.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
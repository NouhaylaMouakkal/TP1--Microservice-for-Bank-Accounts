
package com.mouakkal.bank_account_service.repositories;

import com.mouakkal.bank_account_service.entities.BankAccount;
import com.mouakkal.bank_account_service.entities.Customer;
import com.mouakkal.bank_account_service.entities.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
package com.bancoConta.dto;

import com.bancoConta.entities.Account;
import com.bancoConta.entities.AccountType;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@NoArgsConstructor
public class AccountResponse {
    private Integer id;
    private Integer number;
    private Integer agency;
    private AccountType accountType;
    private BigDecimal balance;
    private Integer userId;

    public static AccountResponse toResponse(Account account){
        AccountResponse response = new AccountResponse();

        response.setId(account.getId());
        response.setNumber(account.getNumber());
        response.setAgency(account.getAgency());
        response.setAccountType(account.getAccountType());
        response.setBalance(account.getBalance());
        response.setUserId(account.getUserId());

        return response;
    }
}

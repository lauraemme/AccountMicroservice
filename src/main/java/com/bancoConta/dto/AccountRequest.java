package com.bancoConta.dto;

import com.bancoConta.entities.AccountType;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountRequest {
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private AccountType accountType;
}

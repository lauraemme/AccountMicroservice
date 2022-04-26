package com.bancoConta.services;

import com.bancoConta.dto.AccountResponse;
import com.bancoConta.entities.Account;
import com.bancoConta.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAccountServiceImpl {
    
    @Autowired
    AccountRepository accountRepository;


    public AccountResponse getById(Integer id) {
        return AccountResponse.toResponse((Account) accountRepository.getById(id));
    }
}

package com.bancoConta.services;

import com.bancoConta.clients.GetUserInfo;
import com.bancoConta.dto.AccountRequest;
import com.bancoConta.dto.AccountResponse;
import com.bancoConta.entities.Account;
import com.bancoConta.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountServiceImpl {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GetUserInfo getUserInfo;

    public AccountResponse register(AccountRequest accountRequest, Integer userId) {

        Account account = new Account(accountRequest, getUserInfo.execute(userId));

        accountRepository.save(account);

        return AccountResponse.toResponse(account);
    }
}

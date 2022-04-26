package com.bancoConta.controller;

import com.bancoConta.dto.AccountRequest;
import com.bancoConta.dto.AccountResponse;
import com.bancoConta.services.GetAccountServiceImpl;
import com.bancoConta.services.RegisterAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    RegisterAccountServiceImpl registerAccountService;

    @Autowired
    GetAccountServiceImpl getAccountService;

    @PostMapping("/new")
    public AccountResponse register(@RequestBody AccountRequest accountRequest, @PathVariable Integer userId){
        return registerAccountService.register(accountRequest, userId);
    }

    @GetMapping("/{id}")
    private AccountResponse findAccountById(@PathVariable Integer id){
        return getAccountService.getById(id);
    }
}

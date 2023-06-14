package com.example.employeesystemapi.service.impl;

import com.example.employeesystemapi.entity.AccountEntity;
import com.example.employeesystemapi.model.Account;
import com.example.employeesystemapi.repository.AccountRepository;
import com.example.employeesystemapi.service.AccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(account, accountEntity);
        accountRepository.save(accountEntity);

        return account;
    }


}

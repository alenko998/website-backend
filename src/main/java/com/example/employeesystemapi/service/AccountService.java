package com.example.employeesystemapi.service;

import com.example.employeesystemapi.model.Account;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    Account createAccount(Account account);

}

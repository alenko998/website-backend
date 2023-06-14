package com.example.employeesystemapi.controller;

import com.example.employeesystemapi.entity.AccountEntity;
import com.example.employeesystemapi.model.Account;
import com.example.employeesystemapi.repository.AccountRepository;
import com.example.employeesystemapi.service.AccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
public class AccountController {
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public AccountController(AccountService accountService,  AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }
    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password, HttpServletResponse response) {
        Optional<Account> accountOptional = accountRepository.findAccountEntitiesByEmailAndPassword(email, password);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            Long accountId = account.getId();

            // Set the user ID in a cookie
            Cookie cookie = new Cookie("id", String.valueOf(accountId));
            cookie.setMaxAge(24 * 60 * 60); // Cookie expiry time in seconds (e.g., 24 hours)
            cookie.setPath("/"); // Set the cookie path

            response.addCookie(cookie);

            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

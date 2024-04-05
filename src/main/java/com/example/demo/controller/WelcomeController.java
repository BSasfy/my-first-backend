package com.example.demo.controller;

import com.example.demo.repository.DatabaseHandlingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

import com.example.demo.model.Account;

@RestController
@RequestMapping("/api")
public class WelcomeController {
    private final DatabaseHandlingRepository databaseHandlingRepository;

    public WelcomeController(DatabaseHandlingRepository databaseHandlingRepository) {
        this.databaseHandlingRepository = databaseHandlingRepository;
    }

    @GetMapping("/hello-endpoint")
    public String welcome() {
        return "Hello!";
    }

    @GetMapping("/all-accounts")
         public Iterable getAllAccounts() {
         System.out.println(databaseHandlingRepository.findAll());
         return databaseHandlingRepository.findAll();
    }

    /**
     * ResponseEntity<Account> - this represents the whole http response with status code, headers and body.
     *
     * Next we'll look at sending a json response using Postman with a different endpoint
     */
    @PostMapping("/save-account")
    public ResponseEntity<Account> saveAccount() {
        Account newAccount = new Account(123L, "Barbara", "hfiowehf", LocalDate.now());
        databaseHandlingRepository.save(newAccount);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

}

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

//    @GetMapping("/account")
//         public Account account() {
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//         Account newAccount = Account.builder().build();
//         // .dob(LocalDate.parse("07/08/1991", formatter)).build();
//         // Account newAccount = new Account(123, "Barbara", "hfiowehf", "fjioejf");
//         System.out.println(newAccount);
//         return newAccount;
//    }

    /**
     * Delete this after you've read it or keep it for reference
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

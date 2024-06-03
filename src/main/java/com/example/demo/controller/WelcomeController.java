package com.example.demo.controller;

import com.example.demo.repository.DatabaseHandlingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.model.Account;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    @GetMapping("/account/{accountNumber}")
    public Account getAccount(@PathVariable Long accountNumber) {

        Optional<Account> optionalAccount = databaseHandlingRepository.findById(accountNumber);

        if (!optionalAccount.isPresent()) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
            // throw new NoSuchElementException("no account found");
        }
        Account account = optionalAccount.get();
        return account;
    }

    /**
     * ResponseEntity<Account> - this represents the whole http response with status
     * code, headers and body.
     *
     * Next we'll look at sending a json response using Postman with a different
     * endpoint
     */
    @PostMapping("/save-account")
    public ResponseEntity saveAccount(@RequestParam int accountNumber, @RequestParam String name,
            @RequestParam String address, @RequestParam String dob) {
        Account newAccount = new Account(accountNumber, name, address, dob);
        databaseHandlingRepository.save(newAccount);
        // return ResponseEntity.ok(HttpStatus.ACCEPTED);

        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

}

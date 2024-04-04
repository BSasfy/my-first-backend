package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.demo.model.Account;

@RestController
@RequestMapping("/api")
public class WelcomeController {
    private DatabaseHandlingRepository databaseHandlingRepository;

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
    @PostMapping("/save-account")
    public Account saveAccount() {
        Account newAccount = new Account(123, "Barbara", "hfiowehf", LocalDate.now());
        databaseHandlingRepository.save(newAccount);
        return newAccount;
    }

}



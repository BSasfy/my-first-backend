package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Account implements Serializable {
    private int accountNumber;
    private String name;
    private String address;
    private LocalDate dob;
}

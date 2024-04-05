package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
// without this it causes a "No default constructor for entity 'com.example.demo.model.Account'"
// you need a default constructor here so lombok does it nicely for us
@NoArgsConstructor

// we need this marks the class as a persistent entity
@Entity
public class Account implements Serializable {
    //this tells spring that this variable will be a unique identity for this entity in the database
    @Id
    private Long accountNumber;
    private String name;
    private String address;
    private LocalDate dob;
}

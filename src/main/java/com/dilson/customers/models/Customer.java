package com.dilson.customers.models;

import java.time.LocalDate;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String cpf;

    @Column(nullable = true)
    private String rg;

    @Column(nullable = true)
    private LocalDate birthdate;

    @NotBlank
    @Column(nullable = false)
    private String phone;

    @NotBlank
    @Column(nullable = false)
    private String street;
 
    @Column(nullable = true)
    private String number_address;

    @NotBlank
    @Column(nullable = false)
    private String zip_code;

    @NotBlank
    @Column(nullable = false)
    private String neighborhood;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @Column(nullable = true)
    private String complement;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
}

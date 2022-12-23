package com.mohmos.fullstack.employment.Model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String jobbTittel;

    public Employee(String firstName, String lastName, String email, String jobbTittel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobbTittel = jobbTittel;
    }
}

package com.prince.taskflow.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data                  // Lombok: generates getters, setters, toString, equals
@NoArgsConstructor     // Lombok: generates no-args constructor
@AllArgsConstructor    // Lombok: generates all-args constructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}

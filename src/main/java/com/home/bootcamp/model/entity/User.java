package com.home.bootcamp.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username cannot be empty")
    @Max(value = 20, message = "Username can be less than 20 characters")
    private String username;

    @NotBlank(message = "Surname cannot be empty")
    @Max(value = 40, message = "Surname can be less than 40 characters")
    private String surname;

    @NotBlank(message = "Patronymic cannot be empty")
    @Max(value = 40, message = "Patronymic can be less than 40 characters")
    private String patronymic;

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;
}

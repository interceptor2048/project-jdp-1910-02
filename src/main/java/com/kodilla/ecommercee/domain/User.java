package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Column(name = "name")
    @NotNull
    private String userName;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long userId;

    @Column(name = "isBlocked")
    private boolean isBlocked;

    public User(@NotNull String userName, boolean isBlocked) {
        this.userName = userName;
        this.isBlocked = isBlocked;
    }
}
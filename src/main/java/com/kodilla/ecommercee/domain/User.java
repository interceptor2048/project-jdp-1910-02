package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "user")
public class User {

    @Column (name="name")
    @NotNull
    private String userName;

    @Column (name = "id")
    @Id
    @GeneratedValue
    @NotNull
    private Long userId;

    @Column (name = "isBlocked")
    private boolean isBlocked;
}
package com.kodilla.ecommercee.user;

import lombok.AllArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@Table(name = "user")
public class User {
    private String userName;
    private long userId;
    private boolean isBlocked;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "User_id")
    public long getUserId() {
        return userId;
    }

    @Column(name = "User_name")
    @NotNull
    public String getUserName() {
        return userName;
    }

    @Column(name = "Blocked:")
    public boolean isBlocked() {
        return isBlocked;
    }
}
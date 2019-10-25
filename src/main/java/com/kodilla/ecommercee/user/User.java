package com.kodilla.ecommercee.user;

import lombok.AllArgsConstructor;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "USER")
public class User {
    private String userName;
    private long userId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "User_id")
    public Long getUserId() {
        return userId;
    }

    @Column(name = "User_name")
    public String getUserName() {
        return userName;
    }
}
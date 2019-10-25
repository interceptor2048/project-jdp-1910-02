package com.kodilla.ecommercee.user;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
    private String userName;
    private String userId;
    private boolean isBlocked;

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        this.isBlocked = false;
    }

    public User() {
    }

    @Column (name="user_name")
    @NotNull
    public String getUserName() {
        return userName;
    }

    @Column (name = "user_id")
    @Id
    @GeneratedValue
    @NotNull
    public String getUserId() {
        return userId;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
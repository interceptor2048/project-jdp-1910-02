package com.kodilla.ecommercee.domain;

public class User {
    private String userName;
    private String userId;
    private boolean isBlocked;

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        this.isBlocked = false;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }
}
package com.kodilla.ecommercee.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
public class UserDto {
    private String userName;
    private Long userId;
    private boolean isBlocked;

    public UserDto(String userName, Long userId, Boolean isBlocked) {
        this.userName = userName;
        this.userId = userId;
        this.isBlocked = isBlocked;
    }

    public String getUserName() {
        return userName;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
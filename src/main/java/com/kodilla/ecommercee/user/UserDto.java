package com.kodilla.ecommercee.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String userId;
    private boolean isBlocked;

}
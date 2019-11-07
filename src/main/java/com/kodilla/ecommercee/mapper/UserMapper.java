package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserName(),
                userDto.getUserId(),
                userDto.isBlocked());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserName(),
                user.getUserId(),
                user.isBlocked()
        );
    }
}

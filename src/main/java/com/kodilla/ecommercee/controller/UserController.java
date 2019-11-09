package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.UserNotAuthorisedException;
import com.kodilla.ecommercee.controller.exception.UserNotFoundException;
import com.kodilla.ecommercee.domain.Token;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommercee/user")

public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UserMapper mapper;

    @PostMapping(path = "/createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(mapper.mapToUser(userDto));
    }

    @PutMapping(path = "/blockUser")
    public UserDto blockUser(@RequestParam Long userId) throws UserNotFoundException {
        UserDto tempUserDto = mapper.mapToUserDto(service.findUser(userId).orElseThrow(UserNotFoundException::new));
        tempUserDto.setBlocked(true);
        return mapper.mapToUserDto(service.saveUser(mapper.mapToUser(tempUserDto)));
    }

    @GetMapping(path = "/getToken")
    public String getToken(@RequestParam Long userId, String userName) throws UserNotAuthorisedException, UserNotFoundException, NoSuchAlgorithmException {
        UserDto tempUserDto = mapper.mapToUserDto(service.findUser(userId).orElseThrow(UserNotFoundException::new));
        if (tempUserDto.getUserName().equals(userName)) {
            Token token = new Token(LocalTime.now(), LocalTime.now().plus(1, ChronoUnit.HOURS));
            return token.getGeneratedToken();
        } else throw new UserNotAuthorisedException();
    }
}
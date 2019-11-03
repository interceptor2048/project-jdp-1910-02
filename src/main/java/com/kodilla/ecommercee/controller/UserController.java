package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.UserNotFoundException;
import com.kodilla.ecommercee.domain.Token;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping ("/v1/ecommercee")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UserMapper mapper;

    @RequestMapping(method = RequestMethod.POST, value="createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser (@RequestBody UserDto userDto) {
        service.saveUser(mapper.mapToUser(userDto));
    }


    @RequestMapping(method = RequestMethod.PUT, value ="blockUser")
    public UserDto blockUser (@RequestParam Long userId) throws UserNotFoundException{
        UserDto tempUserDto = mapper.mapToUserDto(service.findUser(userId).orElseThrow(UserNotFoundException::new));
        tempUserDto.setBlocked(true);
        return mapper.mapToUserDto(service.saveUser(mapper.mapToUser(tempUserDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value="getToken")
    public String getToken (@RequestParam Long userId, String userName) throws UserNotFoundException{
        UserDto tempUserDto = mapper.mapToUserDto(service.findUser(userId).orElseThrow(UserNotFoundException::new));
        if (tempUserDto.getUserName().equals(userName)) {
            Token token = new Token(LocalTime.now(),LocalTime.now().plus(1,ChronoUnit.HOURS));
            return token.getToken();
        }
        else return "Invalid user data";
    }
}
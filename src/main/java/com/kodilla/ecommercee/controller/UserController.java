package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping ("/v1/ecommercee")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value="createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser (@RequestBody UserDto userDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value ="blockUser")
    public UserDto blockUser (@RequestParam String userId) {
        return new UserDto("testUser","testUserId");
    }

    @RequestMapping(method = RequestMethod.GET, value="getToken")
    public String generateToken (@RequestParam String userId) {
        return "testToken";
    }
}
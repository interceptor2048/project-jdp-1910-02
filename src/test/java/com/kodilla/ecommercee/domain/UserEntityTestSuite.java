package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.UserService;
import org.h2.tools.Server;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {

    @Autowired
    private UserService userService;

    @BeforeClass
    public static void initTest() throws SQLException {
        Server webServer = Server.createWebServer("-web",
                "-webAllowOthers", "-webPort", "8082");
        webServer.start();
    }

    @Test
    public void testNewUser() {
        //Given
        User tom = new User("Tom",1L,false);
        userService.saveUser(tom);
        //When
        long checkId = tom.getUserId();
        //Then
        Assert.assertEquals(1,checkId);
    }

    @Test
    public void testRemoveUser() {
        //Given
        User john = new User("John",2313L,false);
        User rick = new User("Rick",213L,false);
        User piotr = new User("Piotr",3L,false);
        userService.saveUser(john);
        userService.saveUser(rick);
        userService.saveUser(piotr);
        userService.deleteUser(john.getUserId());
        //When
        int expectedResult = userService.getAllUsers().size();
        //Then
        Assert.assertEquals(2,expectedResult);
    }

}

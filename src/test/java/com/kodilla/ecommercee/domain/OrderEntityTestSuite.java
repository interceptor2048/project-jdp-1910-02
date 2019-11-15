package com.kodilla.ecommercee.domain;


import com.kodilla.ecommercee.service.OrderService;
import org.h2.tools.Server;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuite {

    @Autowired
    OrderService orderService;

    @BeforeClass
    public static void initTest() throws SQLException {
        Server webServer = Server.createWebServer("-web",
                "-webAllowOthers", "-webPort", "8082");
        webServer.start();
    }

    @Test
    public void saveOrderTest() {
        //Given
        Order first = new Order(1L,"First",200.0,null,null);

        orderService.saveOrder(first);
        //When
        long checkInDatabase = first.getId();
        //Then
        Assert.assertEquals(1,checkInDatabase);
    }

    @Test
    public void removeFromDbTest() {
        //Given
        Order first = new Order(1L,"First",100.0,null,null);
        Order second = new Order(2L,"Second",200.0,null,null);
        Order third = new Order(3L,"Third",300.0,null,null);

        orderService.saveOrder(first);
        orderService.saveOrder(second);
        orderService.saveOrder(third);
        orderService.deleteOrder(third.getId());
        //When
        List<Order> checkDb = orderService.getOrders();
        //Then
        Assert.assertEquals(2,checkDb.size());
    }

    @Test
    public void checkOrdersTest() {
        //Given
        Order firt = new Order(1L,"First",100.0,null,null);
        Order second = new Order(2L,"Second",200.0,null,null);
        Order third = new Order(3L,"Third",300.0,null,null);

        orderService.saveOrder(firt);
        orderService.saveOrder(second);
        orderService.saveOrder(third);
        //When
        List<Order> checkOrders = orderService.getOrders();
        //Then
        Assert.assertEquals(3,checkOrders.size());
    }
}

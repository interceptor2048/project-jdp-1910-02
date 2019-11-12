package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ProductService;

import org.h2.tools.Server;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    private ProductService productService;

    @Autowired
    private GroupService groupService;

    @BeforeClass
    public static void initTest() throws SQLException {
        Server webServer = Server.createWebServer("-web",
                "-webAllowOthers", "-webPort", "8082");
        webServer.start();
    }

    @Test
    public void testProductEntity() {
        //Given
        Group rtv = new Group("rtv","Produkty RTV");
        Product monitor = new Product (2323L,"name",3.22,"description",null,null);
        rtv.getProducts().add(monitor);
        monitor.setProductGroup(rtv);
        //When
        groupService.saveGroup(rtv);
        productService.saveProduct(monitor);
        //Then
    }
}

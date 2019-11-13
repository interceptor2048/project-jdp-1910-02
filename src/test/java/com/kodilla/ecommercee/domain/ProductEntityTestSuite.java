package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.GroupService;
import com.kodilla.ecommercee.service.ProductService;
import com.kodilla.ecommercee.service.UserService;
import org.assertj.core.internal.Lists;
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
    public void shouldWriteToDb() {
        //Given
        Product monitor = new Product ("monitor",499,"Full HD monitor",null,null);
        productService.saveProduct(monitor);
        //When
        long expectedId = monitor.getId();
        //Then
        Assert.assertNotEquals(0,expectedId);
    }

    @Test
    public void shouldRemoveFromDb() {
        //Given
        Product monitor = new Product ("name",3.22,"description",null,null);
        Product tv = new Product("New type LCD screen",2499.99,"LG",null,null);
        productService.saveProduct(monitor);
        productService.saveProduct(tv);
        productService.deleteProduct(tv.getId());
        //When
        int expectedProductsCount = productService.getProducts().size();
        //Then
        Assert.assertEquals(1,expectedProductsCount);
    }

    @Test
    public void shouldWriteToProductGroupId() {
        //Given
        Product monitor = new Product ("name",3.22,"description",null,null);
        Group rtv = new Group("RTV","Produkty RTV w ofercie sklepu");
        rtv.getProducts().add(monitor);
        monitor.setProductGroup(rtv);
        groupService.saveGroup(rtv);
        productService.saveProduct(monitor);

        //When
        Long rtvId = rtv.getId();
        Long monitorId = monitor.getId();
        Long expectedId = productService.getProduct(monitorId).get().getProductGroup().getId();

        //Then
        Assert.assertEquals(rtvId,expectedId);
    }
}

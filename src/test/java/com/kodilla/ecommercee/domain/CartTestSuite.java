package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import org.h2.tools.Server;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartTestSuite {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @BeforeClass
    public static void initTest() throws SQLException {
        Server webServer = Server.createWebServer("-web",
                "-webAllowOthers", "-webPort", "8082");
        webServer.start();
    }

//    @AfterClass
//    public static void endTest() throws SQLException {
//        Server.shutdownTcpServer("jdbc:h2:localhost:8082",
//                "", true, true);
//    }

    @Test
    public void shouldGetId() {
        //Given
        Cart cart = new Cart(new User("Name", true));
        //When
        cartService.saveCart(cart);
        long expected = cart.getId();
        long id = cartService.getCart(expected).get().getId();
        //Then
        assertEquals(expected, id);
    }

    @Test
    public void shouldGetCart() {
        //Given
        Cart cart = new Cart(new User("Name", true));
        //When
        cartService.saveCart(cart);
        long expected = cart.getId();
        Cart addedCart = cartService.getCart(expected).get();
        //Then
        assertEquals(cart, addedCart);
    }

    @Test
    public void shouldGetUser() {
        //Given
        Cart cart = new Cart(new User("Name", true));
        String expectedName = cart.getUser().getUserName();
        //When
        cartService.saveCart(cart);
        long expected = cart.getId();
        String name = cartService.getCart(expected).get().getUser().getUserName();
        //Then
        assertEquals(name, expectedName);
    }

    @Test
    public void shouldGetProducts() {
        //Given
        Cart cart = new Cart(new User("Name", true));
        Group rtv = new Group("RTV", "TV sets and others");
        Product tv = new Product("New type LCD screen", 2499.99, "LG", rtv);
        Product radio = new Product("New Panasonic", 99.99, "Panasonic radio with CD", rtv);
        //When
        cartService.saveCart(cart);
        productService.saveProduct(tv);
        productService.saveProduct(radio);
        long id = cartService.getCart(cart.getId()).get().getId();
        cartService.addProduct(id, tv);
        cartService.addProduct(id, radio);
        int products = cartService.getProducts(id).size();
        //Then
        assertEquals(2, products);
    }
}
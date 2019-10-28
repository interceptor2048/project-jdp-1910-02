package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = "application/json")
    public void newCart(@RequestBody CartDto cartDto) {

    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addToCart", consumes = "application/json")
    public void addToCart(@RequestBody ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteProduct(@RequestParam Long productId) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "newOrder")
    public void createOrder(@RequestParam Long cartId) {
    }
}
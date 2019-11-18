package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/cart")
public class CartController {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartService cartService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OrderController orderController;

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = "application/json")
    public void newCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam Long cartId) {
        return productMapper.mapToProductDtoList(cartService.getCart(cartId)
                .orElse(new Cart()).getProducts());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addToCart", consumes = "application/json")
    public void addToCart(@RequestParam Long cartId, @RequestBody ProductDto productDto) {
        cartService.addProduct(cartId, productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteProduct(@RequestParam Long cartId, @RequestParam Long productId) {
        cartService.deleteProduct(cartId, productId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "newOrder")
    public void createOrder(@RequestParam Long cartId) {
        cartService.createOrder(cartId);
    }
}
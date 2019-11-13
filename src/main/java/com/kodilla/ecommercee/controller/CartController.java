package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/ecommercee")
public class CartController {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartService cartService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderController orderController;

    @RequestMapping(method = RequestMethod.POST, value = "newCart", consumes = "application/json")
    public void newCart(@RequestBody CartDto cartDto) {
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam Long cartId) {
        return productMapper.mapToProductDtoList(cartService.getCart(cartId).orElse(new Cart()).getProducts());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addToCart", consumes = "application/json")
    public void addToCart(@RequestParam Long cartId, @RequestBody ProductDto productDto) throws NotFoundException{
        Cart updatedCart = cartService.getCart(cartId).orElseThrow(NotFoundException::new);
        updatedCart.getProducts().add(productMapper.mapToProduct(productDto));
        cartService.saveCart(updatedCart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFromCart")
    public void deleteProduct(@RequestParam Long cartId, @RequestParam Long productId) throws NotFoundException {
        Cart updatedCart = cartService.getCart(cartId).orElseThrow(NotFoundException::new);
        updatedCart.getProducts().removeIf(t -> productId.equals(t.getId()));
        cartService.saveCart(updatedCart);
    }

    @RequestMapping(method = RequestMethod.POST, value = "newOrder")
    public void createOrder(@RequestParam Long cartId) {
        StringBuilder sb = new StringBuilder();
        Cart cart = cartService.getCart(cartId).get();
        double total = cart.getProducts().stream().map(Product::getPrice).mapToDouble(Double::doubleValue).sum();
        BigDecimal totalCost = BigDecimal.valueOf(total);
        OrderDto newOrder = orderMapper.mapToOrderDto(new Order(sb.append(cart.getUser().getUserName()).append("_").
                append(cart.getId()).toString(),total,cart.getUser(),cart));
        orderController.createOrder(newOrder);
    }
}
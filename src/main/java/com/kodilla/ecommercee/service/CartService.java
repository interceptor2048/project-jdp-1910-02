package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.OrderController;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderController orderController;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCart(final Long cartId) {
        return cartRepository.findById(cartId);
    }

    public List<Product> getProducts(final Long cartId) {
        if (cartRepository.findById(cartId).isPresent()) {
            return cartRepository.findById(cartId).get().getProducts();
        }
        return new ArrayList<>();
    }

    public void addProduct(final Long cartId, final Product product) {
        if (cartRepository.findById(cartId).isPresent()) {
            Cart cart = cartRepository.findById(cartId).get();
            cart.getProducts().add(product);
            cartRepository.save(cart);
        }
    }

    public void createOrder(final Long cartId) {
        StringBuilder sb = new StringBuilder();
        Cart cart = new Cart();
        if (cartRepository.findById(cartId).isPresent()) {
            cart = cartRepository.findById(cartId).get();
        }
        double total = cart.getProducts().stream().map(Product::getPrice)
                .mapToDouble(Double::doubleValue).sum();
        OrderDto newOrder = orderMapper.mapToOrderDto(new Order(sb.append(cart.getUser().getUserName())
                .append("_").append(cart.getId()).toString(), total, cart.getUser(), cart));
        orderController.createOrder(newOrder);
    }

    public void deleteProduct(final Long cartId, final Long productId) {
        if (cartRepository.findById(cartId).isPresent()) {
            Cart cart = cartRepository.findById(cartId).get();
            cart.getProducts().removeIf(t -> productId.equals(t.getId()));
            cartRepository.save(cart);
        }
    }
}
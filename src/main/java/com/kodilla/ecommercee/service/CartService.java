package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCart(final Long cartId) {
        return cartRepository.findById(cartId);
    }

    public void deleteCart(final Long cartId) {
        cartRepository.deleteById(cartId);
    }

    public List<Product> getProducts(final Long cartId) {
        return cartRepository.findById(cartId).get().getProducts();
    }

    public void addProduct(final Long cartId, final Product product) {
        cartRepository.findById(cartId).get().getProducts().add(product);
    }
}
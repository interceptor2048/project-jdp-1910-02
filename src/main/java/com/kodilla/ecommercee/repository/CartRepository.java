package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository <Cart, Long> {

    @Override
    Optional<Cart> findById(Long cartId);

    @Override
    List<Cart> findAll();

    @Override
    Cart save(Cart cart);

    void deleteById(Long cartId);
}

package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.user.User;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private long id;
    private User user;
    private List<Product> products;

    public Cart(long id, User user) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }
}

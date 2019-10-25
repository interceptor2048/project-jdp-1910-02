package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.user.User;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="carts")
public class Cart {
    private long id;
    private User user;
    private List<Product> products;

    public Cart(long id, User user) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>();
    }

    public Cart() {
    }

    @GeneratedValue
    @Id
    @NotNull
    @Column(name = "cart_id")
    public long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="join_product_cart",
            joinColumns = {@JoinColumn(name="cart_id",referencedColumnName = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

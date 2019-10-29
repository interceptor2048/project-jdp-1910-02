package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table (name = "carts")
public class Cart {
    @GeneratedValue
    @Id
    @NotNull
    @Column(name = "cart_id")
    private long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_name")
    private User user;

    @OneToMany(
            mappedBy = "cart"
    )
    private List<Product> products;

    public Cart(long id, User user) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>();
    }
}

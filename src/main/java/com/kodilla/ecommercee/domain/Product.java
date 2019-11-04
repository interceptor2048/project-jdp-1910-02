package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Product(Long id, String name, double price, String description) {
    }
}

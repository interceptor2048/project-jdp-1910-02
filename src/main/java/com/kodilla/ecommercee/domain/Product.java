package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
    private String description;

    @Column(name = "product_id")
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    @NotNull
    public String getName() {
        return name;
    }

    @Column(name = "price")
    @NotNull
    public double getPrice() {
        return price;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

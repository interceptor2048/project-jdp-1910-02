package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "group")
    private List<Product> products = new ArrayList<>();

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

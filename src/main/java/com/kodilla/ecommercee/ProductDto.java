package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductsList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private String description;
    private ProductsList productsList;

}

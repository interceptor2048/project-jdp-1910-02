package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {

    private Long id;
    private String name;
    private String description;
    private List<Product> products;
}

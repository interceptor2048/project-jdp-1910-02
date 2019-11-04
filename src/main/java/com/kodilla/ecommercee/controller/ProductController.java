package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
@Transactional
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllProducts", consumes = "application/json")
    public List<ProductDto> getAllProducts() {
        return new ArrayList<ProductDto>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) {
        return new ProductDto(1L, "test product", 2.32, "test descripton");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = "application/json")
    public void createProduct(@RequestBody ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct", consumes = "application/json")
    public void updateProduct(@RequestBody ProductDto productDto) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct", consumes = "application/json")
    public void deleteProduct(@RequestParam Long productId) {

    }
}
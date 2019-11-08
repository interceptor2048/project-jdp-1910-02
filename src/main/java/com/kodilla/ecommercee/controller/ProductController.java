package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.NotFoundException;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper mapper;

    @GetMapping(path = "/getAllProducts")
    public List<ProductDto> getAllProducts() {
        return mapper.mapToProductDtoList(service.getProducts());
    }

    @GetMapping(path = "/getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws NotFoundException {
        return mapper.mapToProductDto(service.getProduct(productId).orElseThrow(NotFoundException::new));
    }

    @PostMapping(path = "/createProduct", consumes = "application/json")
    public void createProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(mapper.mapToProduct(productDto));
    }

    @PutMapping(path = "/updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return mapper.mapToProductDto(service.saveProduct(mapper.mapToProduct(productDto)));
    }

    @DeleteMapping(path = "/deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        service.deleteProduct(productId);
    }
}
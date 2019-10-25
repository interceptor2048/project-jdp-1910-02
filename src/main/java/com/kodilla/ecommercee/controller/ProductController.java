package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.ProductDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
@Transactional
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getAllProducts", consumes = "application/json")
    public List<ProductDto> getAllProducts(){
        return new ArrayList<ProductDto>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId){
        return new ProductDto() ;
    }

    @RequestMapping(method = RequestMethod.POST, value = "newProduct", consumes = "application/json")
    public void createNewProduct(@RequestBody ProductDto productDto){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct", consumes = "application/json")
    public void updateProduct(@RequestBody ProductDto productDto){

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct", consumes = "application/json")
    public void deleteProduct(@RequestParam Long productId){

    }
}

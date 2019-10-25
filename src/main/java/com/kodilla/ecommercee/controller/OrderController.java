package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder", consumes = "application/json")
    public void createOrder(@RequestBody OrderDto orderDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto(1L, "test_title", "test_content");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder", consumes = "application/json")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, "Edited test title", "test content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
    }
}

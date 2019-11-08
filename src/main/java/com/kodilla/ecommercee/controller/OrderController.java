package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.OrderNotFoundException;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @GetMapping(path = "/getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderService.getOrders());
    }

    @PostMapping(path = "/createOrder", consumes = "application/json")
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderMapper.mapToOrder(orderDto));
    }

    @GetMapping(path = "/getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @PutMapping(path = "/updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

    @DeleteMapping(path = "/deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
    }
}

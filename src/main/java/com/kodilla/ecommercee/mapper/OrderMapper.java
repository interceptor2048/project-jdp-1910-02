package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {


    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getTitle(),
                orderDto.getTotalCost(),
                orderDto.getUser(),
                orderDto.getCart());
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getTitle(),
                order.getTotalCost(),
                order.getUser(),
                order.getCart());
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(o -> new OrderDto(o.getId(), o.getTitle(), o.getTotalCost(), o.getUser(), o.getCart()))
                .collect(Collectors.toList());
    }
}

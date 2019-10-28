package com.kodilla.ecommercee.domain.dto;

import lombok.Getter;

@Getter
public class OrderDto {
    private Long id;
    private String title;
    private String content;

    public OrderDto() {
    }

    public OrderDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
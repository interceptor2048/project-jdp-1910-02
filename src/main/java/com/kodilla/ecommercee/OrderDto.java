package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
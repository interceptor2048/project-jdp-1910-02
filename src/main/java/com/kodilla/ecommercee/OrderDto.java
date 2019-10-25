package com.kodilla.ecommercee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "totalcost")
    private double totalCost;

/*
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    !!>> na ten moment nie jest gotowa klasa User, stąd komentarz
    Inaczej wysypuje sie aplikacja. Jak tylko będzie klasa to dodam zależność<<!!
 */

}
package com.rest.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    User user;
}

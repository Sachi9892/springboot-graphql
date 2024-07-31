package com.curiouscoder.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private String orderDetails;

    private int price;

    @ManyToOne
    private User user;
}

package com.curiouscoder.controller;

import com.curiouscoder.entity.OrderClass;
import com.curiouscoder.service.OrderService;
import com.curiouscoder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @MutationMapping
    public OrderClass createOrder(
            @Argument String orderDetails ,
            @Argument int price ,
            @Argument int userId) {

        OrderClass order = new OrderClass();
        order.setOrderDetails(orderDetails);
        order.setUser(userService.getById(userId));
        order.setPrice(price);

        return orderService.createOder(order);

    }


    @MutationMapping
    public boolean deleteOrder(@Argument int orderId) {
        return orderService.deleteOrder(orderId);
    }


    @QueryMapping(name =  "getOrder")
    public OrderClass getSingleOrder(@Argument int id) {
        return orderService.getById(id);
    }


    @QueryMapping(name =  "getOrders")
    public List<OrderClass> allOrders() {
        return orderService.allOrders();
    }



}

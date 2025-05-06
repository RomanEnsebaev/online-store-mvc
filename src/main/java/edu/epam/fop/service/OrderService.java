package edu.epam.fop.service;

import edu.epam.fop.entity.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
    Order getOrderById(Long id);
}

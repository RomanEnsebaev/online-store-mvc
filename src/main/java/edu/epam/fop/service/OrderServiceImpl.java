package edu.epam.fop.service;

import edu.epam.fop.dao.order.OrderDAO;
import edu.epam.fop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDao;

    @Override
    public void placeOrder(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderDao.findByUserId(userId);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.findById(id);
    }
}
package edu.epam.fop.dao.orderItem;

import edu.epam.fop.dao.GenericDao;
import edu.epam.fop.entity.OrderItem;

import java.util.List;

public interface OrderItemDAO extends GenericDao<OrderItem> {
    List<OrderItem> findByOrderId(Long orderId);
}

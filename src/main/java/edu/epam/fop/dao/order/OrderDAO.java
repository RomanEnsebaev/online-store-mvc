package edu.epam.fop.dao.order;

import edu.epam.fop.dao.GenericDao;
import edu.epam.fop.entity.Order;

import java.util.List;

public interface OrderDAO extends GenericDao<Order> {
    List<Order> findByUserId(Long userId);
}

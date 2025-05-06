package edu.epam.fop.dao.orderItem;

import edu.epam.fop.entity.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemDAOImpl implements OrderItemDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(OrderItem item) {
        em.persist(item);
    }

    @Override
    public OrderItem findById(Long id) {
        return em.find(OrderItem.class, id);
    }

    @Override
    public List<OrderItem> findAll() {
        return em.createQuery("FROM OrderItem", OrderItem.class).getResultList();
    }

    @Override
    public void update(OrderItem item) {
        em.merge(item);
    }

    @Override
    public void delete(OrderItem item) {
        em.remove(em.contains(item) ? item : em.merge(item));
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        return em.createQuery("FROM OrderItem i WHERE i.order.id = :orderId", OrderItem.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }

}

package edu.epam.fop.dao.order;

import edu.epam.fop.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("FROM Order", Order.class).getResultList();
    }

    @Override
    public void update(Order order) {
        em.merge(order);
    }

    @Override
    public void delete(Order order) {
        em.remove(em.contains(order) ? order : em.merge(order));
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return em.createQuery("FROM Order o WHERE o.user.id = :userId", Order.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}

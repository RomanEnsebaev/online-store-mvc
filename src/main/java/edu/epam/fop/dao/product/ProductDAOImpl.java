package edu.epam.fop.dao.product;

import edu.epam.fop.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
//        return em.createQuery("FROM Product", Product.class).getResultList();
        System.out.println("[DEBUG] ProductDAO: querying products");
        List<Product> products = em.createQuery("FROM Product", Product.class).getResultList();
        System.out.println("[DEBUG] ProductDAO: found " + products.size() + " products");
        return products;
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void delete(Product product) {
        em.remove(em.contains(product) ? product : em.merge(product));
    }

    @Override
    public List<Product> findByName(String name) {
        return em.createQuery("FROM Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getResultList();
    }
}
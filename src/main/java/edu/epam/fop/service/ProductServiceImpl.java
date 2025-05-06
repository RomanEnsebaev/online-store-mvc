package edu.epam.fop.service;

import edu.epam.fop.dao.product.ProductDAO;
import edu.epam.fop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDao;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("[DEBUG] ProductService called");
        return productDao.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findById(id);
    }
}

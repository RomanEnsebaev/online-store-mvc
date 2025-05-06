package edu.epam.fop.service;

import edu.epam.fop.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);
}

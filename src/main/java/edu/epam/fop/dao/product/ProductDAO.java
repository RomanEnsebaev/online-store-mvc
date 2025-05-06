package edu.epam.fop.dao.product;

import edu.epam.fop.dao.GenericDao;
import edu.epam.fop.entity.Product;

import java.util.List;

public interface ProductDAO extends GenericDao<Product> {
    List<Product> findByName(String name);
}

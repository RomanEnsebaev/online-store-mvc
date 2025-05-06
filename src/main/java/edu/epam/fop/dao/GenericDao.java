package edu.epam.fop.dao;

import java.util.List;

public interface GenericDao<T> {
    void save(T entity);
    T findById(Long id);
    List<T> findAll();
    void update(T entity);
    void delete(T entity);
}

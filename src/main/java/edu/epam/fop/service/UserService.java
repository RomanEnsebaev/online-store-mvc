package edu.epam.fop.service;

import edu.epam.fop.entity.User;

public interface UserService {
    void register(User user);
    User findByUsername(String username);
    User findById(Long id);
}

package edu.epam.fop.service;

import edu.epam.fop.dao.user.UserDAO;
import edu.epam.fop.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDao;
    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    @Override
    public void register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }
}

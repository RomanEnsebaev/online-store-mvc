package edu.epam.fop.dao.user;

import edu.epam.fop.dao.GenericDao;
import edu.epam.fop.entity.User;

public interface UserDAO extends GenericDao<User> {
    User findByUsername(String username);
}

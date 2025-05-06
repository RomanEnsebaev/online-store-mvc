package edu.epam.fop.service;

import edu.epam.fop.dao.user.UserDAO;
import edu.epam.fop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("[DEBUG] Trying to load user: " + username);
        User user = userDAO.findByUsername(username);
        if (user == null) {
            System.out.println("[DEBUG] User not found in DB");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("[DEBUG] Looking up user: " + username);


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("USER"))
        );
    }
}
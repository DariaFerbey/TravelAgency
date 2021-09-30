package com.softserve.security;

import com.softserve.model.User;
import com.softserve.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("myUserService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userDao.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return SecurityUserDetails.fromUser(user);
        }
    }
}
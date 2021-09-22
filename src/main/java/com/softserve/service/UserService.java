package com.softserve.service;

import com.softserve.dao.UserDAO;
import com.softserve.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findByName(String name) {
        return userDAO.findByName(name);
    }

    public List<User> getAllUser() {
        return userDAO.getAllUsers();
    }

    public void save(User user){
        userDAO.save(user);
    }

    public boolean isUserExists(User user) {
        List<User> users = userDAO.getAllUsers();
        return users.stream().anyMatch(u->u.getFullName().equals(user.getFullName()));
    }


}

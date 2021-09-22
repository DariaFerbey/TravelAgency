package com.softserve.dao;

import com.softserve.model.User;

import java.util.List;

public interface UserDAO {
    User findByName(String name);
    List<User> getAllUsers();
    void save(User user);
}

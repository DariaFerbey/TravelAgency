package com.softserve.dao.impl;

import com.softserve.dao.UserDAO;
import com.softserve.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl  implements UserDAO {

    private final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByName(String name) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        User user = (User) session.createQuery("from User u where u.fullName=:name", User.class)
                .setParameter("name", name)
                .getSingleResult();
        log.info("Find user by name " + name + ": " + user.getId());
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        List<User> users = session.createQuery("from User", User.class)
                .getResultList();
        log.info("Get list of users");
        return users;
    }

    @Override
    public void save(User user) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        log.info("Save user with name: " + user.getFullName());
        session.save(user);
    }
}

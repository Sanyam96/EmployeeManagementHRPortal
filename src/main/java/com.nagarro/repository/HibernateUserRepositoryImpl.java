package com.nagarro.repository;

import com.nagarro.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Sanyam Goel created on 17/9/18
 */
@Repository
public class HibernateUserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User authenticate(String username, String password) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User WHERE username=:username AND password=:password";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

}
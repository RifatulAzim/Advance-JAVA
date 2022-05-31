package com.dao;


import com.model.User;
import com.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao{

    private final SessionFactory sessionFactory;

    UsersDaoImpl(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}

    @Override
    public List<Users> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Users> userQuery = session.createQuery("from Users", Users.class);
        List<Users> users = userQuery.getResultList();
        return users == null ? new ArrayList<Users>() : users;
    }

    @Override
    public void save(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public Users get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Users.class, id);
    }

    @Override
    public void update(Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void delete(int id) {
        Users user = get(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}

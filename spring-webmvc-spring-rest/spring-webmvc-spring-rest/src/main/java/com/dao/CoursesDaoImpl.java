package com.dao;

import com.model.Courses;
import com.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoursesDaoImpl implements CoursesDao{

    private final SessionFactory sessionFactory;

    public CoursesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Courses> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Courses> coursesQuery = session.createQuery("from Courses", Courses.class);
        List<Courses> courses = coursesQuery.getResultList();
        return courses == null ? new ArrayList<Courses>() : courses;
    }

    @Override
    public void save(Courses course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public Courses get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Courses.class, id);
    }

    @Override
    public void update(Courses course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course);
    }

    @Override
    public void delete(int id) {
        Courses courses = get(id);
        sessionFactory.getCurrentSession().delete(courses);
    }
}

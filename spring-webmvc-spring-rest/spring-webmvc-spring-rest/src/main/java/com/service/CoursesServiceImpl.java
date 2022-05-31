package com.service;

import com.dao.CoursesDao;
import com.model.Courses;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoursesServiceImpl  implements  CoursesService{

    private final CoursesDao coursesDao;

    public CoursesServiceImpl(CoursesDao coursesDao) {
        this.coursesDao = coursesDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Courses> getAll() {
        return coursesDao.getAll();
    }


    @Override
    public void save(Courses courses) {
        coursesDao.save(courses);
    }

    @Override
    public Courses get(int id) {
        return coursesDao.get(id);
    }

    @Override
    public void update(Courses courses) {
        coursesDao.update(courses);
    }

    @Override
    public void delete(int id) {
        coursesDao.delete(id);
    }
}

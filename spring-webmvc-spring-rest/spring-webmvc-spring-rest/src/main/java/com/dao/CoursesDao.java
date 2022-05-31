package com.dao;

import com.model.Courses;


import java.util.List;

public interface CoursesDao {
    public List<Courses> getAll();

    public void save(Courses course);

    public Courses get(int id);

    public void update(Courses course);

    public void delete(int id);
}

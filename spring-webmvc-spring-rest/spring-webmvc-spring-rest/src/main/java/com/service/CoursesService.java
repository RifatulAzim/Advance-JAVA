package com.service;

import com.model.Courses;

import java.util.List;

public interface CoursesService {

    public List<Courses> getAll();

    public void save(Courses courses);

    public Courses get(int id);

    public void update(Courses courses);

    public void delete(int id);
}

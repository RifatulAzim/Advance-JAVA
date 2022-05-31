package com.dao;

import com.model.Users;

import java.util.List;

public interface UsersDao {
    public List<Users> getAll();

    public void save(Users user);

    public Users get(int id);

    public void update(Users user);

    public void delete(int id);

}

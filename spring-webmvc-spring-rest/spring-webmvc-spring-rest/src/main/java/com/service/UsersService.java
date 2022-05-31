package com.service;

import com.model.Users;


import java.util.List;

public interface UsersService {

    public List<Users> getAll();

    public  Users getUser(Users user);

    public boolean checkUserName(Users user);

    public void save(Users user);

    public Users get(int id);

    public void update(Users user);

    public void delete(int id);
}

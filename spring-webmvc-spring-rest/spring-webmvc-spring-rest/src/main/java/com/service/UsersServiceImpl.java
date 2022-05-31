package com.service;


import com.dao.UsersDao;
import com.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class UsersServiceImpl implements  UsersService{

    private final UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> getAll() {
        return  usersDao.getAll();
    }

    @Override
    public Users getUser(Users user) {
        List<Users> usersList = usersDao.getAll();


        for (Users u: usersList) {

             if(Objects.equals(u.getEmail(), user.getEmail()) && Objects.equals(u.getPassword(), user.getPassword())){
                 return u;
             }

        }

        return null;
    }

    @Override
    public boolean checkUserName(Users user) {
        List<Users> usersList = usersDao.getAll();

        for (Users u: usersList) {

            if(Objects.equals(u.getEmail(), user.getEmail())){
                return true;
            }

        }

        return false;
    }


    @Override
    public void save(Users user) {
         usersDao.save(user);
    }

    @Override
    public Users get(int id) {
        return usersDao.get(id);
    }

    @Override
    public void update(Users user) {
        usersDao.update(user);
    }

    @Override
    public void delete(int id) {
        usersDao.delete(id);
    }
}

package com.crud.dao;


import com.crud.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();

    List<User> getById(long id);

    void update(User user);

    void delete(long id);
}

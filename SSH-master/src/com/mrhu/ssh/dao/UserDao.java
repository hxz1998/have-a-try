package com.mrhu.ssh.dao;

import com.mrhu.ssh.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    boolean exist(User user);
    List<User> searchUser();
    User loadUser(int id);
}

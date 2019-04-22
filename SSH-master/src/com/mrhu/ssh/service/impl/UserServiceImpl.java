package com.mrhu.ssh.service.impl;

import com.mrhu.ssh.dao.UserDao;
import com.mrhu.ssh.model.User;
import com.mrhu.ssh.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.add(user);
    }

    @Override
    public boolean exist(User user) {
        return userDao.exist(user);
    }

    @Override
    public List<User> getUserList() {
        return userDao.searchUser();
    }

    @Override
    public User getUserById(int id) {
        return userDao.loadUser(id);
    }

}

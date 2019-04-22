package com.mrhu.ssh.dao.impl;

import com.mrhu.ssh.dao.UserDao;
import com.mrhu.ssh.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public boolean exist(User user) {
        List<User> users = (List<User>) hibernateTemplate.find("from User user where user.username = ?", user.getUsername());
        if(users.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> searchUser() {
        return (List<User>) this.hibernateTemplate.find("from User");
    }

    @Override
    public User loadUser(int id) {
        return (User)this.hibernateTemplate.load(User.class, id);
    }
}

package com.mrhu.ssh.util;

import com.mrhu.ssh.model.User;
import com.mrhu.ssh.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* HibernateUtil Tester. 
* 
* @author mrhu
* @since <pre>02/17/2018</pre> 
* @version 1.0 
*/ 
public class HibernateUtilTest {
    @Test
    public void testGetSessionFactory() throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.getTransaction().commit();
    }

    @Test
    public void testSaveUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = new User();
        user.setPassword("765482");
        user.setUsername("张三");
        session.save(user);
        session.getTransaction().commit();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> list = session.createQuery("from User user where user.username = :name")
            .setParameter("name", user.getUsername())
            .list();
        Assert.assertEquals(list.size(), 1);

    }

    @Test
    public void testDeleteUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = new User();
        user.setUsername("张三");
        Query query = session.createQuery("from User user where user.username = :name");
        query.setParameter("name", user.getUsername());
        List<User> list = query.list();
        if(list.size() == 0) {
            Assert.fail("空的list");
        } else {
            session.delete(list.get(0));
            session.getTransaction().commit();
        }
    }
}

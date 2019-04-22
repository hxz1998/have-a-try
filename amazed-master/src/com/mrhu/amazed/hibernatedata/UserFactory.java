/**
 * @author Mr.Hu
 * 
 * 注意！不要关闭掉 session 否则还得时刻注意要打开 session
 */
package com.mrhu.amazed.hibernatedata;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mrhu.amazed.model.User;
import com.mrhu.amazed.util.HibernateUtil;


public class UserFactory {
	
	private static final SessionFactory sessionFactory; 
	private static Session session;
	
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
//		session = sessionFactory.openSession();
	}
	
	/**
	 * 用来验证的用户
	 * @return 得到用户的详细信息用来验证
	 */
	public static User getUser(String password) {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("password", password));
		List<User> users = criteria.list();
		session.getTransaction().commit();
		
		//校验是否获取到了唯一的用户
		
		if(users.size() == 0) {
			return null;
		} else if(users.size() == 1){
			return users.get(0);
		} else {
			return null;
		}
	}
}

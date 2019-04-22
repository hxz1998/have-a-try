/**
 * @author Mr.Hu
 * @since 20180201
 * 
 * hibernate 辅助类，静态获取 SessionFactory 对象
 * 
 */
package com.mrhu.amazed.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	//一定要先configure之后再获取工厂
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}

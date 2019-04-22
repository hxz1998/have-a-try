/**
 * 
 */
package com.mrhu.amazed.queryaction;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.mrhu.amazed.model.User;
import com.mrhu.amazed.util.HibernateUtil;

/**
 * @author Mr.Hu
 *
 */
public class UserActionTest {

	@Test
	public void test() {
		User testU = new User();
		testU.setPassword("f28");
		testU.setUsername("张大");
		User u2 = new User();
		u2.setPassword("fjdskl");
		u2.setUsername("fdjskalf");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(testU);
		session.getTransaction().commit();
		
		UserAction action = new UserAction();
		action.setUser(u2);
		System.out.println(action.execute());
	}

}

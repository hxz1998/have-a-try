package com.mrhu.amazed.hibernatedata;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.mrhu.amazed.model.Transcripts;
import com.mrhu.amazed.model.User;
import com.mrhu.amazed.util.HibernateUtil;

public class TranscriptFactory {
	
	private static String transcriptFromDB;
	private static final SessionFactory sessionFactory;
	private static Session session;
	
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
//		session = sessionFactory.openSession();
	}
	
	/**
	 * 获取指定userId的成绩单
	 * @param userId 用户识别码，也就是 password
	 * @return json类型的字符串
	 */
	public static String getTranscript(String userId) {
		
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Transcripts.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<Transcripts> list = criteria.list();
		session.getTransaction().commit();
		if(list.size() == 0) {
			return null;
		}else {
			transcriptFromDB = list.get(0).getTranscript();
			return transcriptFromDB;
		}
	}
	
}

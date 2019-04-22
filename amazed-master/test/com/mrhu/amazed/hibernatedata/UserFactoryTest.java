package com.mrhu.amazed.hibernatedata;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mrhu.amazed.model.User;

public class UserFactoryTest {

	@Test
	public void test() {
		User user;
		user = UserFactory.getUser("123hua");
		if(user == null) {
			System.out.println("空指针");
		}else{
			System.out.println(user);
		}
	}

}

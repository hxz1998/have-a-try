package com.mrhu.amazed.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() {
		User u1 = new User();
		User u2 = new User();
		u1.setPassword("123456");
//		u2.setPassword("123456");
		u2.setPassword("473829174");
		u1.setUsername("刘关张");
		u2.setUsername("刘关张");
		System.out.println(u1.equals(u2));
	}

}

package com.mrhu.ssh.service.impl;

import com.mrhu.ssh.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* UserServiceImpl Tester. 
* 
* @author mrhu
* @since <pre>02/18/2018</pre> 
* @version 1.0 
*/ 
public class UserServiceImplTest { 

    @Test
    public void testSave() throws Exception { 
    }


    @Test
    public void testExist() throws Exception { 
    }

    @Test
    public void testSerchUser() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
    }

} 

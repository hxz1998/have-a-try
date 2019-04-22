package com.mrhu.amazed.verify;

import com.mrhu.amazed.hibernatedata.UserFactory;
import com.mrhu.amazed.model.User;

public class VerifyUser {
	
	//储存从服务器获取过来的对象
	private static User userFromDatabase;
	
	/**
	 * 验证是否用户名和用户密码一致
	 * @param beVerifyUser 被验证的对象
	 * @return 如果身份一致，就返回真
	 */
	public static boolean verify(User beVerifyUser) {
		userFromDatabase = UserFactory.getUser(beVerifyUser.getPassword());
		if(userFromDatabase == null) {
			return false;
		}else {
			if(userFromDatabase.equals(beVerifyUser)){
				return true;
			}else {
				return false;
			}
		}
	}
	
	
}

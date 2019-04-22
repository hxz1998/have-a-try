/**
 * @author Mr.Hu
 * 
 * 这里的password就是身份证号，同时也是数据库中的索引，主键
 */

package com.mrhu.amazed.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {
	
	private String username;
	private String password;
	private Transcripts list;
	
	/**
	 * 重写equals方法，获得两个对象比较之后的结果
	 * @return 返回两个User比较之后的结果
	 */
	@Override
	public boolean equals(Object user) {
		if((((User) user).getPassword().equals(this.password)) && (((User) user).getUsername().equals(this.getUsername()))){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return username + password;
	}
	
	/**
	 * @return
	 */
	@Transient
	public Transcripts getList() {
		return list;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param struts2容器赋值进来
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	@Id
	public String getPassword() {
		return password;
	}
	/**
	 * @param struts2容器赋值进来
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param list
	 */
	public void setList(Transcripts list) {
		this.list = list;
	}
	
}

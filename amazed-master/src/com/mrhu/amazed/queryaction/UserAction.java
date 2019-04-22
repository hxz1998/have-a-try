package com.mrhu.amazed.queryaction;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.mrhu.amazed.hibernatedata.TranscriptFactory;
import com.mrhu.amazed.model.User;
import com.mrhu.amazed.verify.VerifyUser;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware{
	
	private User user;
	private Map<String, Object> request;
	
	/**
	 * 验证用户
	 */
	@Override
	public String execute() {
		if(VerifyUser.verify(user)) {
			request.put("getTranscript", TranscriptFactory.getTranscript(user.getPassword()));
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}

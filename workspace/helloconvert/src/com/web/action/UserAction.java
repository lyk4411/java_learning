package com.web.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private String create(){
		System.out.println(user.getMail());
		
		return SUCCESS;
	}
}

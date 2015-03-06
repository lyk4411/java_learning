package com.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport  {
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String hello(){
		if(name == null || name.trim().equalsIgnoreCase("god")){
			this.addActionError(this.getText("error.hello.nameinvalidate"));
			
			return INPUT;
		}
		return SUCCESS;
	}
}

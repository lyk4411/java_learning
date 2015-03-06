package com.domain;

import java.util.HashSet;
import java.util.Set;


public class Group {
	private Integer id;
	private String name;
	private Set<User> users = new HashSet<User>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

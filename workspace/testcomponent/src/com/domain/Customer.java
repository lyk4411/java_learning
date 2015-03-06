package com.domain;

public class Customer {
	private Integer id;
	private String name;
	private Address home;
	private Address company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getHome() {
		return home;
	}
	public void setHome(Address home) {
		this.home = home;
	}
	public Address getCompany() {
		return company;
	}
	public void setCompany(Address company) {
		this.company = company;
	}
	
}

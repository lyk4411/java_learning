package com.domain;

import java.sql.Timestamp;

public class News {
	private Integer id;
	private String title;
	private String content;
	private Timestamp createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/*  <servlet>
  	<description></description>
  	<display-name>ListNewsServlet</display-name>
  	<servlet-name>ListNewsServlet</servlet-name>
  	<servlet-class>com.web.servlet.ListNewsServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ListNewsServlet</servlet-name>
  	<url-pattern>/listnews.html</url-pattern>
  </servlet-mapping>*/
}

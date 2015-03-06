package com.web.action;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.domain.User;

public class UserConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] value, Class toClass) {
		// TODO Auto-generated method stub
		String ss[] =value[0].split(",");
		
		User u = new User();
		u.setName(ss[0]);
		u.setAge(Integer.parseInt(ss[1]));
		u.setMail(ss[2]);
		
		return u;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		User u = (User)o;
		return u.getName() + "," + u.getAge() + "," + u.getMail();
	}

}

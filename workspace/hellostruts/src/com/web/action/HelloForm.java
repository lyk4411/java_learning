package com.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class HelloForm extends ActionForm {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		if(name == null || name.length() == 0){
			errors.add("hello_error", new ActionMessage("error.hello.namenull"));
		}
		
		if(errors.isEmpty()){
			return null;
		}
		return errors;
	}
}

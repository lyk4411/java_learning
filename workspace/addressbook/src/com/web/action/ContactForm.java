package com.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class ContactForm extends ValidatorForm {
	private String name;
	private String phone;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
//	@Override
//	public ActionErrors validate(ActionMapping mapping,
//			HttpServletRequest request) {
//		ActionErrors errors = new ActionErrors();
//		
//		if(name == null || name.trim().length() == 0){
//			errors.add("form_error",new ActionMessage("error.contact.namenull"));
//		}
//		if(phone == null || phone.trim().length() == 0){
//			errors.add("form_error",new ActionMessage("error.contact.phonenull"));
//		}
//		if(errors.isEmpty()){
//			return null;
//		}
//		return errors;
//	}
}

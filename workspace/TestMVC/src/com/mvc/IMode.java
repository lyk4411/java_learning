package com.mvc;

public interface IMode {
	public String getMessage();//view 
	public void setMessage(String msg);//controller
	
	public void addModelListener(IView view);
}

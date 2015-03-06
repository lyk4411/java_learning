package com.mvc;

public interface IView {
	public void processMessageChanged(String msg);//model
	public void showResult(String tip);//controller
	
	public void addViewListener(IController c);
}

package com.mvc.impl;

import com.mvc.IController;
import com.mvc.IMode;
import com.mvc.IView;

public class Controller implements IController {

	private IMode model;
	private IView view;
	
	public Controller(IMode model,IView view){
		this.model = model;
		this.view = view;
		
		view.addViewListener(this);
	}
	
	@Override
	public void doChangeMessage(String msg) {
		// TODO Auto-generated method stub
		model.setMessage(msg);
		view.showResult("change message successfully!");
	}

}

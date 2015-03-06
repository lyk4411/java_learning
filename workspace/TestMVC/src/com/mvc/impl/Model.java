package com.mvc.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



import com.mvc.IMode;
import com.mvc.IView;

public class Model implements IMode {
	private String message = "hello world";
	private Set<IView> listeners = new HashSet<IView>();
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public void setMessage(String msg) {
		// TODO Auto-generated method stub
		message = msg;
		
		Iterator<IView> it = listeners.iterator();
		while(it.hasNext()){
			IView tv = it.next();
			tv.processMessageChanged(message);
		}
	}

	@Override
	public void addModelListener(IView view) {
		// TODO Auto-generated method stub
		listeners.add(view);
	}

}

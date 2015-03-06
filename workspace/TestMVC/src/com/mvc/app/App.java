package com.mvc.app;

import com.mvc.IMode;
import com.mvc.IView;
import com.mvc.impl.Controller;
import com.mvc.impl.Model;
import com.mvc.impl.View;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMode model = new Model();
		
		IView v1 = new View(model);
		IView v2 = new View(model);
		IView v3 = new View(model);
		
		new Controller(model,v1);
		new Controller(model,v2);
		new Controller(model,v3);
	}
}

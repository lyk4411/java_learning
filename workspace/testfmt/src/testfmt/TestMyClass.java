package testfmt;

import java.lang.reflect.*;

public class TestMyClass {
  public static void main(String [] args)  {
    Class c;
	try {
		c = Class.forName("testfmt.MyClass");
		Method [] ms = c.getDeclaredMethods();
	    for (Method m : ms) {
	      if(m.isAnnotationPresent(TestCase.class)) {
	        TestCase tc = m.getAnnotation(TestCase.class);
	        Object o = c.newInstance();
	        String s = tc.value();
	        m.invoke(o, s);
	        //���������������ֱ��д�ɣ�
	        m.invoke(c.newInstance(), tc.value());
	      }
	    }
	  
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  } 
}
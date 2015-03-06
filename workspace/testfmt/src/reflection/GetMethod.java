package reflection;

import java.lang.reflect.Method;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  

class X {
	public void work(String s){
		System.out.println("working on \"" + s + "\"");
	}
}
public class GetMethod {
    Logger logger = LoggerFactory.getLogger(GetMethod.class);
    
    
	public static void main(String[] argv){
		try{
			Class clX = X.class;
			Class[] argTypes = {
					String.class
			};
			Method worker = clX.getMethod("work", argTypes);
			
			Object[] theData = {
					"chips asdfadfa"
			};
		
		worker.invoke(new X(), theData);
	}catch(Exception e){
		System.err.println("Invoke() failed: " + e);
	}
}
}

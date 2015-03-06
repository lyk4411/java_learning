package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demonstrate how finalize() methods and shutdownHooks interact with calls to
 * System.exit().
 */
// BEGIN main
public class ShutdownDemo {
	public static void main(String[] args) throws Exception {
		// Create an Object with a finalize() method - Bad idea!
		Object f = new Object() {
			public void finalize() throws Throwable {
				System.out.println("Running finalize()");
				super.finalize();
			}
		};
		// Add a shutdownHook to the JVM
		//Runtime.getRuntime().exec("ping 127.0.0.1");
        String s = "/n";  
		System.out.println(Runtime.getRuntime().getRuntime());
		System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
		int i= 0;
		try {  
            Process p = Runtime.getRuntime().exec("ping 127.0.0.1"); 
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                s += line + "/n";  
                System.out.println(i + ": "+ line);
                i++;
            }  
            
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Running Shutdown Hook");
			}
		});
		// Unless the user puts -f (this-program-specific argument for "free")
		// on
		// the command line, call System.exit while holding a reference to
		// Object f, which can therefore not be finalized().
		if (args.length == 1 && args[0].equals("-f")) {
			f = null;
			System.gc();
		}
		System.out.println("Calling System.exit(), with f = " + f);
		System.exit(0);
	}
}
// END main
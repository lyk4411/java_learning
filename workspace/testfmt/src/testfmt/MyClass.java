package testfmt;


 
public class MyClass {
  @TestCase("This is Method 1")
  public String Method1 (String s) {
	  System.out.println(s);
	  return s;
  }
 
  public String Method2 (String s) {
    return s;
  }
 
  @TestCase("This is Method 3")
  public String Method3 (String s) {
	System.out.println(s);
    return s;
  }
}
 
package madjava;

import java.lang.reflect.Method;
import java.lang.reflect.Field;



class Person2 implements IPerson2{  
  private String name;  
  private int age;  
  public Person2(){    //无参构造  
        
  }  
  public Person2(String name,int age){  
      this.name = name;  
      this.age = age;  
  }  
  @Override  
  public String toSay() {  
      return "hello!";  
  }  
    
  @Override  
  public String toEat(String name, int age) {  
      return "name: "+name+",age: "+age;  
  }  
  public String getName() {  
      return name;  
  }  
  public void setName(String name) {  
      this.name = name;  
  }  
  public int getAge() {  
      return age;  
  }  
  public void setAge(int age) {  
      this.age = age;  
  }  
}  

public class tall {  
    public static void main(String[] args) throws Exception{  
        Class<?> cl = Class.forName("madjava.Person");  //实例化对象  
        Method m1[] = cl.getMethods();  
        for (int i = 0; i < m1.length; i++) {  
            System.out.println(m1[i]);  
        }  
        System.out.println("*************");  
        Method m2[] = cl.getDeclaredMethods();  
        for (int i = 0; i < m2.length; i++) {  
            System.out.println(m2[i]);  
        }
        System.out.println("*************");  

        Field f1[] = cl.getFields();  
        for (int i = 0; i < f1.length; i++) {  
            System.out.println(f1[i]);  
        }  
        System.out.println("*********");  
        Field f2[] = cl.getDeclaredFields();   //本类中的属性  
        for (int i = 0; i < f2.length; i++) {  
            System.out.println(f2[i]);  
        } 
    }  
}  


interface IPerson2{  
  public static final String NAME = "itmyhome";  
  public String toSay();  
  public String toEat(String name,int age);  
}  

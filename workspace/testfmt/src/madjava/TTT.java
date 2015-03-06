package madjava;

import java.lang.reflect.Constructor;  

class Person1 {  
    private String name;  
    private int age;  
      
    public Person1(String name,int age){  
        this.name = name;  
        this.age = age;  
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
    public String toString() {  
        // TODO Auto-generated method stub  
        return "name: " + name + ",age: " + age;  
    }  
}  
  
public class TTT {  
  
    public static void main(String[] args) throws ClassNotFoundException{  
        Class<?> c = Class.forName("madjava.Person1");  
        Constructor<?> cons[] = c.getConstructors();  
        Person1 Person1 = null;  
        try {  
            Person1 = (Person1) cons[0].newInstance("itmyhome",23);  //实例化对象  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        Person1.setName("itmyhome");  
        Person1.setAge(23);  
        System.out.println(Person1);  
    }  
  
}  
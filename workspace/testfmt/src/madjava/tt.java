package madjava;

class Person {  
    private String name;  
    private int age;  
      
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
  
public class tt {  
  
    public static void main(String[] args) throws ClassNotFoundException {  
        Class<?> c = Class.forName("madjava.Person");  
        Person person = null;  
        try {  
            person = (Person) c.newInstance();  //实例化对象  
        } catch (InstantiationException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        }  
        person.setName("itmyhome");  
        person.setAge(23);  
        System.out.println(person);  
    }  
  
}  
package OCJP;
import java.io.FileOutputStream;  
import java.io.ObjectOutputStream;  
import java.io.Serializable;  
  
public class Forest implements Serializable {  
  
    private Tree12 tree = new Tree12(); //但如果只是private Tree tree;则可以正确执行  
    public static void main(String[] args) {  
        Forest f = new Forest();  
          
        try {  
            FileOutputStream file = new FileOutputStream("file.txt");  
            ObjectOutputStream oo = new ObjectOutputStream(file);  
            oo.writeObject(f);  
            oo.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
class Tree12 implements Serializable {  
      
}  
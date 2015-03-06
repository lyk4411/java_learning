package OCJP;
import java.util.*;  
public class Main1 {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner cin=new Scanner(System.in);  
        int M=cin.nextInt();  
        int T=cin.nextInt();  
        int U=cin.nextInt();  
        int F=cin.nextInt();  
        int D=cin.nextInt();  
        char[] ch;  
        int sum=0;  
        int cont=0;  
        ch=new char[T];  
        for(int i=0;i<T;i++)  
            ch[i]=cin.next().charAt(0);  
        for(int i=0;i<T;i++){  
                switch(ch[i]){  
                    case 'u':  
                        sum+=U+D;  
                        break;  
                    case 'd':  
                        sum+=U+D;  
                        break;  
                    case 'f':  
                        sum+=2*F;  
                        break;  
                }             
                if(sum>M) break;  
                else if(sum==M){  
                    cont++;  
                    break;  
                }  
                else cont++;  
            }         
        System.out.println(cont);  
    }  
}  
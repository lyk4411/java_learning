package OCJP;
import java.util.*;  
public class Main {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner cin=new Scanner(System.in);  
        int N=0;  
        int M=0;  
        int W_exp=0;  
        N=cin.nextInt();  
        W_exp=cin.nextInt();  
        int []W;  
        W=new int[N];  
        for(int i=0;i<N;i++)  
            W[i]=cin.nextInt();  
        Arrays.sort(W);  
        if(W[0]>=W_exp) M=W[0];  
        for(int i=1;i<N;i++)  
            if(W[i]>=W_exp){  
                if(W_exp-W[i-1]<W[i]-W_exp)  
                    M=W[i-1];  
                else M=W[i];  
                break;  
            }  
        if(W[N-1]<W_exp) M=W[N-1];  
        System.out.println(M);  
  
    }  
  
}  
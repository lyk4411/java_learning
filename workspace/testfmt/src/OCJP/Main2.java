package OCJP;
import java.util.*;  
public class Main2{  
    static int box[][]=new int[110][110];     
    static boolean isFull(int box[][],int L){         
            for(int i=0;i<L;i++)  
                for(int j=0;j<L;j++)  
                    if(box[i][j]==0) return false;  
            return true;  
        }  
    static void rep(int box[][],int L){  
            int temp[][]=new int[110][110];  
            for(int i=0;i<L;i++)  
                for(int j=0;j<L;j++)  
                    temp[i][j]=box[i][j];  
            for(int i=0;i<L;i++)  
                for(int j=0;j<L;j++)  
                    if(temp[i][j]==1){  
                        if(i>0&&temp[i-1][j]==0) box[i-1][j]=1;  
                        if(i<L-1&&temp[i+1][j]==0) box[i+1][j]=1;  
                        if(j>0&&temp[i][j-1]==0) box[i][j-1]=1;  
                        if(j<L-1&&temp[i][j+1]==0) box[i][j+1]=1;  
                    }  
        }  
    public static void main(String[] args){  
        Scanner cin=new Scanner(System.in);  
        int L=cin.nextInt();  
        int[][] box=new int[L][L];  
      
        for(int i=0;i<L;i++)  
            for(int j=0;j<L;j++)  
                box[i][j]=cin.nextInt();  
        int cont=0;  
        while(!isFull(box,L))  
        {  
            cont++;  
            rep(box,L);  
        }  
        System.out.println(cont);  
    }  
}  
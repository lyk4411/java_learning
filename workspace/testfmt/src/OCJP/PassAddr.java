package OCJP;

import java.awt.geom.Arc2D.Float;

class Book{
    String name;
    private float price;
    Book(String n,    float p){                //���췽��
        name = n;
        price = p;
    }
    static  void  change(Book a_book,    String n,    float p){    //��̬������������Ϊ����
            a_book.name = n;
            a_book.price = p;
    }
    public void output(){        //ʵ�����������������Ϣ
        System.out.println("name: " + name + "/t" + "price: " + price);
    }
}
 public class PassAddr{
    public static void main(String [] args){
        Book b = new Book("java2",    32.5f);
        System.out.print("before call:/t");        //����ǰ
        b.output();
        b.change(b,    "c++",    45.5f);            //���ô��ݣ����ݶ���b�����ã��޸Ķ���b��ֵ
        System.out.print("after call:/t");            //���ú�
        b.output();
    }
}
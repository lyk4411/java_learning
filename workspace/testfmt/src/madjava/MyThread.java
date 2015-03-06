package madjava;
public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i) % 10 == 0) {
                System.out.println("-------" + i);
            }
            System.out.print(i);
            try {
                Thread.sleep(1);
                System.out.print("    Ïß³ÌË¯Ãß1ºÁÃë£¡\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new MyThread().start();
    }
} 
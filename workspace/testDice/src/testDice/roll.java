package testDice;
import java.io.*;

public class roll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("输入色子数：");
		int num = 0;
		try {
			num = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("输入一个最大数：");
		int max = 0;
		try {
			max = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			int total = 0;
			for (int i = 0; i < num; i++){
				total += rollDice();
			}
			if(total == max){
				System.out.println(count);
				System.out.println(total);
				System.out.println("****************");
				break;
			}
			else {
				count++;
				System.out.println(count);
				System.out.println(total);
				System.out.println("================");
			}
		}
	}
	private static int rollDice(){
		int total = (int) (Math.round((Math.random() * 6)) + 1);
		return total;
	}
}

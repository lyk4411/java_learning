package madjava;

public class chengfa {
	public static void main(String[] args) {
		int i, j = 1;
		for (i = 1; i <= j & i < 10; i++)// ��
		{
			for (j = 1; j <= i; j++)// ��
			{
				int c = i * j;
				System.out.print(i + "*" + j);
				System.out.print("=" + c + " ");
			}
			System.out.println();// ��i=jʱ����
		}
	}
}
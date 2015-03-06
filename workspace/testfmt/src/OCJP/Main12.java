package OCJP;

import java.util.Scanner;

public class Main12 {
	public static void main(String... args) {
		// 打素数表
		for (int i = 1; i < 40; i++) {
			isp[i] = isPrime(i);
		}

		while (cin.hasNext()) {
			n = cin.nextInt();
			if (n == 0)
				break;
			if (n == 1) {// 1形成自环
				System.out.println("Case " + count++ + ":\n1");
				continue;
			}

			if (n % 2 == 1) {// n为奇数则定无解
				System.out.println("Case " + count++ + ":");
				System.out.println("No Answer");
				continue;
			}

			A = new int[n + 1];
			A[1] = 1;// 第一个为1
			System.out.println("Case " + count++ + ":");
			dfs(2);
			if (!hasRes)
				System.out.println("No Answer");
			hasRes = false;
		}
	}

	public static void dfs(int cur) {
		if (cur == n + 1 && isp[A[1] + A[n]]) {
			for (int i = 1; i <= n; i++) {
				System.out.print(A[i] + " ");
			}
			System.out.println();
			hasRes = true;
		}

		else {
			for (int i = 2; i <= n; i++) {// 尝试放置每个数i
				if (!visit[i] && isp[A[cur - 1] + i]) {
					A[cur] = i;
					visit[i] = true;
					dfs(cur + 1);
					visit[i] = false;
				}
			}
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static int[] A;
	static boolean[] isp = new boolean[40];
	static int n, count = 1;
	static boolean[] visit = new boolean[20];
	static Scanner cin = new Scanner(System.in);
	static boolean hasRes = false;
}

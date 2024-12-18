import java.util.*;
import java.io.*;

class Main {

	private static String str1, str2;
	private static int[][] dp;
	private static boolean[][] visited;
	private static StringBuilder answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine();
		str2 = br.readLine();
		answer = new StringBuilder();

		dp = new int[str1.length()][str2.length()];
		visited = new boolean[str1.length()][str2.length()];

		System.out.println(LCS(str1.length() - 1, str2.length() - 1));
		System.out.println(answer);
	}

	private static int LCS(int x, int y) {
		if (x == -1 || y == -1) {
			return 0;
		}

		if (!visited[x][y]) {
			if (str1.charAt(x) != str2.charAt(y)) {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			} else {
				answer.insert(0, str1.charAt(x));
				System.out.println("str1.charAt(x) = " + str1.charAt(x));
				dp[x][y] = LCS(x-1, y-1) + 1;
			}
		}
		visited[x][y] = true;
		return dp[x][y];
	}


}

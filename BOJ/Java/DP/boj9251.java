package DP;

import java.util.*;
import java.io.*;

class boj9251 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int answer = 0;


		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		System.out.println(dp[str1.length()][str2.length()]);
	}
}

class boj9251_topDown {

	private static String str1, str2;
	private static int[][] dp;
	private static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine();
		str2 = br.readLine();

		dp = new int[str1.length()][str2.length()];
		visited = new boolean[str1.length()][str2.length()];

		System.out.println(LCS(str1.length() - 1, str2.length() - 1));
	}

	private static int LCS(int x, int y) {
		if (x == -1 || y == -1) {
			return 0;
		}

		if (!visited[x][y]) {
			if (str1.charAt(x) != str2.charAt(y)) {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			} else {
				dp[x][y] = LCS(x-1, y-1) + 1;
			}
		}
		visited[x][y] = true;
		return dp[x][y];
	}
}


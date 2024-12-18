package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9252 {

	private static int[][] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		dp = new int[str1.length() + 1][str2.length() + 1];

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
		System.out.println(getString(str1, str1.length(), str2.length()));
	}

	private static String getString(String str, int x, int y) {
		StringBuilder answer = new StringBuilder();
		while (x > 0 && y > 0) {
			if (dp[x - 1][y] == dp[x][y]) {
				x--;
			} else if (dp[x][y] == dp[x][y-1]) {
				y--;
			} else {
				answer.insert(0, str.charAt(x-1));
				x--;
				y--;
			}
		}
		return answer.toString();
	}
}

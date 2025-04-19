package DP;

import java.util.*;
import java.io.*;

public class boj1106 {

	static int C, N;
	static int[][] hotel;

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		hotel = new int[N][2];
		dp = new int[C + 101];

		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			hotel[i][0] = Integer.parseInt(st.nextToken());
			hotel[i][1] = Integer.parseInt(st.nextToken());

			int cost = hotel[i][0];
			int person = hotel[i][1];
			int multi = 1;
			while (person * multi <= C + 100) {
				dp[person * multi] = Math.min(dp[person * multi], cost * multi);
				multi++;
			}
		}

		for (int i = 1; i <= C + 100; i++) {
			for (int j = i - 1; j > i / 2 ; j--) {
				if (dp[j] == Integer.MAX_VALUE || dp[i - j] == Integer.MAX_VALUE) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
			if (i % 2 == 0 && dp[i / 2] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i / 2] * 2);
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = C; i <= C + 100; i++) {
			answer = Math.min(answer, dp[i]);
		}
		System.out.println(answer);

	}

}
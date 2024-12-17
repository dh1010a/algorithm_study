package DP;

import java.util.*;
import java.io.*;

class boj11052 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] card = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		dp[1] = card[1];
		for (int i = 2; i <= N; i++) {
			int mid = i / 2;
			if (i % 2 != 0) {
				mid++;
			}
			for (int j = mid; j <= i; j++) {
				dp[i] = Math.max(Math.max(dp[j] + dp[i - j], card[i]), dp[i]);
			}
		}
		System.out.println(dp[N]);

	}


}

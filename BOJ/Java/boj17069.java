import java.util.*;
import java.io.*;

class boj17069 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		long[][][] dp = new long[n][n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 2; j < n; j++) {
				// 가로
				if (j - 1 >= 0 && map[i][j] == 0) {
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				}
				// 세로
				if (i - 1 >= 0 && map[i][j] == 0) {
					dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				}
				// 대각
				if (i - 1 >= 0 && j -1 >= 0 && map[i][j-1] == 0 && map[i-1][j] == 0 && map[i-1][j-1] == 0) {
					dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		long answer = dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
		System.out.println(answer);

	}


}


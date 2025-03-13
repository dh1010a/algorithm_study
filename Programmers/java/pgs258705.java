public class pgs258705 {

	public int solution(int n, int[] tops) {
		int MOD = 10007;
		int[][] dp = new int[n][2];

		dp[0][0] = 1;
		dp[0][1] = tops[0] == 1 ? 3 : 2;
		for (int i = 1; i < n; i++) {
			if (tops[i] == 1) {
				dp[i][0] = dp[i-1][0] + dp[i-1][1];
				dp[i][1] = dp[i-1][0] * 2 + dp[i-1][1] * 3;
			} else {
				dp[i][0] = dp[i-1][0] + dp[i-1][1];
				dp[i][1] = dp[i-1][0] + dp[i-1][1] * 2;
			}
			dp[i][0] = dp[i][0] % MOD;
			dp[i][1] = dp[i][1] % MOD;
		}
		return (dp[n-1][0] + dp[n-1][1]) % MOD;

	}
}

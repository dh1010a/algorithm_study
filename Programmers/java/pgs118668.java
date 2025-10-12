import java.util.Arrays;

class pgs118668 {

	static int INF = 30001;

	public int solution(int alp, int cop, int[][] problems) {
		int maxAlp = 0;
		int maxCop = 0;

		for (int[] prb : problems) {
			maxAlp = Math.max(maxAlp, prb[0]);
			maxCop = Math.max(maxCop, prb[1]);
		}

		if (alp >= maxAlp && cop >= maxCop) {
			return 0;
		}

		maxAlp = Math.max(maxAlp, alp);
		maxCop = Math.max(maxCop, cop);


		int[][] dp = new int[maxAlp + 1][maxCop + 1];

		for (int[] x : dp) {
			Arrays.fill(x, INF);
		}

		dp[alp][cop] = 0;

		for (int i = alp; i <= maxAlp; i++) {
			for (int j = cop; j <= maxCop; j++) {
				int now = dp[i][j];

				if (i + 1 <= maxAlp) {
					dp[i + 1][j] = Math.min(dp[i + 1][j], now + 1);
				}

				if (j + 1 <= maxCop) {
					dp[i][j + 1] = Math.min(dp[i][j + 1], now + 1);
				}

				for (int[] prb : problems) {
					if (prb[0] <= i && prb[1] <= j) {
						int na = Math.min(maxAlp, i + prb[2]);
						int nc = Math.min(maxCop, j + prb[3]);

						dp[na][nc] = Math.min(dp[na][nc], now + prb[4]);
					}
				}

			}
		}

		return dp[maxAlp][maxCop];
	}
}
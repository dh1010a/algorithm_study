import java.util.*;

class leet322 {
	public int coinChange(int[] coins, int amount) {

		if (amount == 0) {
			return 0;
		}

		long[] dp = new long[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i < coins.length; i++) {
			if (amount < coins[i]) {
				continue;
			}
			dp[coins[i]] = 1;
		}
		dp[0] = 0;


		for (int i = 1; i <= amount; i++) {

			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] > 0) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}

		}
		if (dp[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return (int) dp[amount];

	}
}
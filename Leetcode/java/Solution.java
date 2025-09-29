import java.util.*;

class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length];

		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < cost.length; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1]) + cost[i];
		}
		return dp[cost.length - 1];
	}
}
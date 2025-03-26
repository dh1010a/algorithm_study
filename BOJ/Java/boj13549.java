import java.util.*;
import java.io.*;

public class boj13549 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dp = new int[100001];

		Arrays.fill(dp, Integer.MAX_VALUE - 1);

		for (int i = 0; i <= N; i++) {
			dp[i] = N - i;
			if (2 * i > N && i * 2 < dp.length) {
				dp[i * 2] = dp[i];
			}
		}

		dp[N] = 0;

		for (int i = N; i <= K + 1; i++) {
			if (i == 0) {
				dp[i+1] = dp[i] + 1;
				continue;
			}
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2]);

			if (i == 100000) {
				System.out.println(dp[i]);
				return;
			}
			dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
			dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);
			if (i * 2 > 100000) {
				continue;
			}
			dp[i * 2] = Math.min(dp[i], dp[i * 2]);
		}

		System.out.println(dp[K]);
	}
}
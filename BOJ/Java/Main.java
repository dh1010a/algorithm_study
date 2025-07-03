import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int answer = 0;


		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		String now = br.readLine();
		String target = br.readLine();

		dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= n; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j- 1])) + 1;
				if (target.charAt(i-1) == now.charAt(j-1) ||
						(now.charAt(j - 1) == 'v' && target.charAt(i-1) == 'w') ||
						(now.charAt(j - 1) == 'i' && target.charAt(i-1) == 'j') ||
						(now.charAt(j - 1) == 'i' && target.charAt(i-1) == 'l')
				) {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		System.out.println(dp[m][n]);
	}

}
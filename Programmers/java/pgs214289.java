import java.util.*;

class pgs214289 {
    private static final int MAX = 100 * 1000 + 1;

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        // -10의 인덱스는 접근할 수 없기 때문에, 전체적으로 10을 더해 인덱스 접근이 가능하도록 함.
        t1 += 10;
        t2 += 10;
        int[][] dp = new int[onboard.length][51];
        for (int[] x : dp) {
            Arrays.fill(x, MAX);
        }
        // 실외 온도

        int temp = temperature + 10;
        dp[0][temp] = 0;
        for (int i = 0; i < onboard.length - 1; i++) {
            for (int j = 0; j < 51; j++) {
                // 승객 탑승시, 적정온도가 아니면
                if (onboard[i] == 1 && !(j >= t1 && j <= t2)) {
                    continue;
                }
                // 에어컨 On
                // 온도 유지
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + b);
                // 온도 내림
                if (j > 0) dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j] + a);
                // 온도 올림
                if (j < 50) dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + a);

                // 에어컨 Off
                if (temp == j) { // 온도 유지
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
                } else if (temp < j && j > 0) { // 온도 하강
                    dp[i+1][j-1] = Math.min(dp[i+1][j-1], dp[i][j]);
                } else if (temp > j && j < 50) { // 온도 상승
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                }
            }
        }
        int answer = MAX;
        for (int i = 0; i < 51; i++) {
            // 마지막에 승객 탑승시 적정온도가 아니라면
            if (onboard[onboard.length-1] == 1 && !(i >= t1 && i <= t2)) {
                continue;
            }
            answer = Math.min(answer, dp[onboard.length-1][i]);
        }

        return answer;
    }
}

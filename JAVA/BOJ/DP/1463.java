import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        dp = new Integer[x + 1];
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = (dp[i] > dp[i / 2] ? dp[i / 2] + 1 : dp[i]);
            if (i % 3 == 0)
                dp[i] = (dp[i] > dp[i / 3] ? dp[i / 3] + 1 : dp[i]);
        }
        System.out.println(dp[x]);
        br.close();
    }
}
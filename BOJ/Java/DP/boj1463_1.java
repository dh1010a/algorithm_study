import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.Math;

public class Main {
    public static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];
        System.out.println(recur(x));
        br.close();
    }
    public static int recur(int number) {
        if (number == 1){
            return 0;
        }
        if (dp[number] > 0){
            return dp[number];
        }
        if (number % 2 == 0){
            dp[number] = Math.min(dp[number], cal(dp[number/2]) + 1);
        }
        else if (number % 3 == 0){
            dp[number] = Math.min(dp[number], cal(dp[number/3]) + 1);
        }
        else{
            dp[number] = cal(dp[number]) + 1;
        }
        return dp[number];
    }
}
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        long[][] dp = new long[N+1][10];
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int j = 2; j <= N ; j++){
            for(int l = 0 ; l <= 9 ; l++){
                for(int k = 0; k <= l ; k++){
                    dp[j][l] += dp[j-1][k];
                    dp[j][l] %= 10007;
                }
            }
            
        }
        int result = 0;
        for(int m = 0; m < 10 ; m++){
            result += dp[N][m];
        }
        System.out.println(result%10007);
    }
}
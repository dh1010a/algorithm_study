//https://school.programmers.co.kr/learn/courses/30/lessons/1832

import java.util.*;

class Solution {
    int MOD = 20170805;
    int left = 0;
    int up = 1;
    int[][][] dp;
    
    public int solution(int m, int n, int[][] cityMap) {
        dp = new int[m][n][2];
        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) break;
            dp[0][i][left] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            dp[i][0][up] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;
                
                int left_tmp = dp[i][j-1][left];
                if (cityMap[i][j-1] == 0) {
                    left_tmp = (left_tmp + dp[i][j-1][up]) % MOD;
                }
                
                int up_tmp = dp[i-1][j][up];
                if (cityMap[i-1][j] == 0) {
                    up_tmp = (up_tmp + dp[i-1][j][left]) % MOD;
                }
                dp[i][j][left] = left_tmp;
                dp[i][j][up] = up_tmp;
            }
        }
        
        
        return (dp[m-1][n-1][left] + dp[m-1][n-1][up]) % MOD;
    }
}
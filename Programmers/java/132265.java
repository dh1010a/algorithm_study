import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> total = new HashSet<>();
        int[] dp = new int[topping.length];
        for (int i = 0; i < dp.length; i++) {
            total.add(topping[i]);
            dp[i] = total.size();
        }
        total.clear();
        int[] dp2 = new int[topping.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            total.add(topping[i]);
            dp2[i] = total.size();
        }
        
        for (int i = 0; i < topping.length - 1; i++) {
            if (dp[i] == dp2[i+1]) {
                answer++;
            }
        }
        
        
        return answer;
    }
}
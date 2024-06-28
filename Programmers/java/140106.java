import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long tmp = (long) Math.pow(d, 2);
        for (int i = 0; i <= d; i+=k) {
            long jj = (long) Math.pow(i, 2);
            int result = (int)(Math.sqrt(tmp - jj));
            answer += result / k + 1;
        }
        return answer;
    }
}
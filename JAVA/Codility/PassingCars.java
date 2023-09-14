// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                list.add(i);
            }
        }
        int len = list.size();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                answer += len;
                if (answer > 1000000000) {
                    return -1;
                }
            } else {
                len--;
            }
        }
        return answer;
    }
}
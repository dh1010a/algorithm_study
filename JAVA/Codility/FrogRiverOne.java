// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here
        Set<Integer> s = new HashSet<>();
        int idx = 0;
        while (s.size() < X && idx < A.length) {
            if (!s.contains(A[idx])) {
                s.add(A[idx]);
            }
            idx++;
        }
        if (s.size() == X) {
            return idx - 1;
        } else {
            return -1;
        }
    }
}
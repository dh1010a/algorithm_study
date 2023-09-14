// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        int tmp = 0;
        for (int x: A) {
            set.add(x);
            tmp = Math.max(x, tmp);
        }
        if (A.length == tmp && A.length == set.size()) {
            return 1;
        } else {
            return 0;
        }
    }
}
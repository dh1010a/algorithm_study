import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here
        Set<Integer> s = new HashSet<>();
        int time = 0;
        for (int i : A) {
            s.add(i);
            if (s.size() == X) {
                return time;
            }
            time++;
        }
        return -1;
    }
}
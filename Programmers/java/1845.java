import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            set.add(x);
        }
        return set.size() >= nums.length / 2 ? nums.length / 2 : set.size();
    }
}
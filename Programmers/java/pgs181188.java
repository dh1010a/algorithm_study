import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        for (int[] x: targets) {
            queue.add(x);
        }
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            while (!queue.isEmpty() &&
                  queue.peek()[0] < x[1]) {
                queue.poll();
            }
            answer++;
        }
        
        return answer;
    }
}
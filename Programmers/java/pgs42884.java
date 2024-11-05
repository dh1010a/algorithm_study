import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));
        for(int[] x: routes) {
            queue.add(x);
        }
        while(!queue.isEmpty()) {
            int[] x = queue.poll();
            while(!queue.isEmpty() && 
                  queue.peek()[0] <= x[1] &&
                  queue.peek()[1] >= x[1]) {
                
                queue.poll();
            }
            answer++;
        }
        return answer;
    }
}
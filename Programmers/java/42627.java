import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Queue<int[]> timeq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int[] x : jobs) {
            pq.add(x);
        }
        int time = 0;
        while (!pq.isEmpty() || !timeq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= time)
                timeq.add(pq.poll());
            
            if (timeq.isEmpty()) {
                time = pq.peek()[0];
            } else {
                int[] tmp = timeq.poll();
                answer += (time - tmp[0]) + tmp[1];
                time += tmp[1];
            }
            
        }
        return answer/jobs.length;
    }
}
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;

        // 작업 요청 시점을 기준으로 하는 우선순위 큐
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[0]-o2[0];
        });
        PriorityQueue<int[]> timeq = new PriorityQueue<>((o1, o2) -> {
            return o1[1]-o2[1];
        });
        
        for (int i = 0; i < jobs.length; i++)
            q.add(jobs[i]);
        
        while (!q.isEmpty() || !timeq.isEmpty()) {
            while(!q.isEmpty() && q.peek()[0] <= time) {
                timeq.add(q.poll());
            }
            if (timeq.isEmpty()) {
                time = q.peek()[0];
            } else { 
                int[] tmp = timeq.poll();
                answer += time - tmp[0] + tmp[1];
                time += tmp[1];
            }
            
        }
        
        return answer/jobs.length;
    }
}
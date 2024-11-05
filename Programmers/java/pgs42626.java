import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for(int x: scoville) {
            pq.add(x);
        }
        while(pq.peek() < K && pq.size() >= 2){
            int x = pq.poll();
            int y = pq.poll();
            pq.add(x + y*2);
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}
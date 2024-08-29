import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for (int[] x: fares) {
            graph[x[0]][x[1]] = x[2];
            graph[x[1]][x[0]] = x[2];
        }
        
        int[][] cost = new int[3][n+1];
        for (int i = 0; i < 3; i++)
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        
        int[] target = {s, a, b};
        for (int i = 0; i < 3; i++) {
            Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            int start = target[i];
            cost[i][start] = 0;
            pq.add(new int[]{start, 0});
            
            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                
                for (int j = 1; j <= n; j++) {
                    if (graph[now[0]][j] == 0) continue;
                    if (cost[i][j] > now[1] + graph[now[0]][j]) {
                        cost[i][j] = now[1] + graph[now[0]][j];
                        pq.add(new int[]{j, cost[i][j]});
                    }
                }
            }
        }
        answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int[] x : cost) {
                sum += x[i];
            }
            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
}
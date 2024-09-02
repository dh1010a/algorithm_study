import java.util.*;

class Solution {
    
    class Edge implements Comparable<Edge> {
        int node;
        int intense;
        
        public Edge(int node, int intense) {
            this.node = node;
            this.intense = intense;
        }
        
        @Override
        public int compareTo(Edge diff) {
            return this.intense - diff.intense;
        }
    }
    
    Map<Integer, List<Edge>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        // Arrays.sort(summits);
        answer[1] = Integer.MAX_VALUE;
        for (int x : summits) {
            set.add(x);
        }
        
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            map.get(path[0]).add(new Edge(path[1], path[2]));
            map.get(path[1]).add(new Edge(path[0], path[2]));
        }
        
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<Edge> pq = new PriorityQueue<>();
        for (int x : gates) {
            pq.add(new Edge(x, 0));
            visited[x] = 0;
        }
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.node] < now.intense || set.contains(now.node)) continue;
            
            for (Edge next : map.get(now.node)) {
                int nextIntense = Math.max(next.intense, now.intense);
                if (visited[next.node] > nextIntense){
                    visited[next.node] = nextIntense;
                    pq.add(new Edge(next.node, visited[next.node]));
                }
            }
        }
        for (int x: summits) {
            // 아래 과정을 하지 않기 위해서는 sort를 해야함
            if (visited[x] == answer[1]) {
                if (answer[0] > x) {
                    answer[0] = x;
                }
            }
            else if (visited[x] < answer[1]) {
                answer[0] = x;
                answer[1] = visited[x];
            }
        }
        return answer;
    }
}
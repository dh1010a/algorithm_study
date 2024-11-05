import java.util.*;

class Solution {
    public int[][] tree;
    
    public int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        q.addFirst(start);
        int cnt = 0;
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.pollLast();

            for (int i = 1; i <= n; i++) {
                if (now != i && !visited[i] && tree[now][i] == 1) {
                    q.addFirst(i);
                    visited[i] = true;
                }
            }
            cnt++;
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            tree = new int[n+1][n+1];
            for (int j = 0; j < wires.length; j++) {
                if (j != i) {
                    tree[wires[j][0]][wires[j][1]] = 1;
                    tree[wires[j][1]][wires[j][0]] = 1;
                }
            }
            int n1 = bfs(wires[i][0], n);
            int n2 = bfs(wires[i][1], n);

            answer = Math.min(Math.abs(n1 - n2), answer);
        }
        
        
        return answer;
    }
}
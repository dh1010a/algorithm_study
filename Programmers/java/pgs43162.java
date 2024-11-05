import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[] visited;
    int answer;
    
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int x, int n) {
        visited[x] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[x][i] == 1) {
                dfs(computers, i, n);
            }
        }
    }
    
}
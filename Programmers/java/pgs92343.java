import java.util.*;
class Solution {
    boolean[] visited;
    
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        return dfs(info, edges, 1, 0);
    }
    
    public int dfs(int[] info, int[][] edges, int sheep, int wolf) {
        if (sheep == wolf) return sheep;
        int maxSheep = sheep;
        
        for (int[] edge : edges) {
            int p = edge[0];
            int c = edge[1];
            if (visited[p] && !visited[c]) {
                visited[c] = true;
                if (info[c] == 0) {
                    maxSheep = Math.max(maxSheep, dfs(info, edges, sheep+1, wolf));
                } else {
                    maxSheep = Math.max(maxSheep, dfs(info, edges, sheep, wolf+1));
                }
                visited[c] = false;
            }
        }
        return maxSheep;
        
    }

}
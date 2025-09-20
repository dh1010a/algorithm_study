import java.util.*;
class pgs92343 {

    boolean[] visited;

    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        return dfs(edges, info, 0, 1);
    }

    public int dfs(int[][] edges, int[] info, int wolf, int sheep) {
        if (wolf == sheep) {
            return sheep;
        }
        int maxSheep = sheep;

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][0];

            if (visited[x] && !visited[y]) {
                visited[y] = true;
                if (info[y] == 1) {
                    maxSheep = Math.max(dfs(edges, info, wolf + 1, sheep), maxSheep);
                } else {
                    maxSheep = Math.max(dfs(edges, info, wolf, sheep + 1), maxSheep);
                }
                visited[y] = false;
            }
        }
        return maxSheep;
    }
}
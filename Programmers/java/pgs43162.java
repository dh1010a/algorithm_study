import java.util.*;

class pgs43162 {
    boolean[] visited;
    int answer = 0;

    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(computers, i);
            }
        }

        return answer;
    }

    public void dfs(int[][] computers, int now) {
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && i != now && computers[now][i] == 1) {
                visited[i] = true;
                dfs(computers, i);
            }
        }
    }

}
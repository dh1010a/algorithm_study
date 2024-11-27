import java.util.*;

class pgs1844 {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public boolean[][] visited;
    public int n, m;

    public int solution(int[][] maps) {
        int min = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            Node now = dq.remove();
            if (now.x == n - 1 && now.y == m - 1) {
                min = Math.min(min, now.cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    dq.add(new Node(nx, ny, now.cnt + 1));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static class Node{
        public int x;
        public int y;
        public int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int r, c;
    public int solution(int[][] maps) {
        int answer = 0;
        r = maps.length;
        c = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == r-1 && now[1] == c-1) {
                return maps[r-1][c-1];
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (isRange(nx, ny) && maps[nx][ny] == 1) {
                    maps[nx][ny] += maps[now[0]][now[1]];
                    q.add(new int[]{nx, ny});
                }
            }
        }        
        return -1;
    }
    
    private boolean isRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
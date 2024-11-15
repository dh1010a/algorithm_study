package D4;

import java.util.*;
import java.io.*;

class swea1868 {

    static char[][] map;
    static int N, result;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            result = 0;

            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != '*' && !visited[i][j] && countBomb(i, j) == 0 ) {
                        result++;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.') {
                        result++;
                        map[i][j] = (char)(countBomb(i, j) + '0');
                    }
                }
            }


            System.out.println("#" + tc + " " + result);
        }
    }

    public static void bfs(int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        visited[x][y] = true;

        dq.add(new int[]{x, y});

        while (!dq.isEmpty()) {
            int[] now = dq.remove();
            int bombCnt = countBomb(now[0], now[1]);
            map[now[0]][now[1]] = (char)('0' + bombCnt);
            if (bombCnt > 0) {
                continue;
            }
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int nx = now[0] + i;
                    int ny = now[1] + j;
                    if (nx == x && ny == y) {
                        continue;
                    }
                    if (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != '*') {
                        visited[nx][ny] = true;
                        dq.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }

    public static int countBomb(int x, int y) {
        int cnt = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx == x && ny == y) {
                    continue;
                }
                if (isRange(nx, ny) && map[nx][ny] == '*') {
                    cnt++;
                }
            }
        }
        return cnt;
    }



    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }


}

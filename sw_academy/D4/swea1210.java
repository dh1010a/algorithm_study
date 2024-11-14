package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea1210 {

    static int[][] board;
    static int result;
    static int[] dx = {0, 0, -1};
    static int[] dy = {1, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = 10;

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int startX = 0;
            int startY = 0;

            board = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            Deque<int[]> dq = new ArrayDeque<>();
            dq.add(new int[]{startX, startY});
            boolean[][] visited = new boolean[100][100];

            visited[startX][startY] = true;
            while (!dq.isEmpty()) {
                int[] now = dq.remove();
                if (now[0] == 0) {
                    result = now[1];
                    break;
                }

                for (int i = 0; i < 3; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (isRange(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dq.add(new int[]{nx, ny});
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < 100 && y >= 0 && y < 100 && board[x][y] == 1;
    }
}

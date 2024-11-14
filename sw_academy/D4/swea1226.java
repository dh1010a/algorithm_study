package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class swea1226 {

    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = 10;

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int startX = 0, startY = 0, arrivalX = 0, arrivalY = 0, result = 0;

            board = new int[16][16];
            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    board[i][j] = str.charAt(j) - '0';
                    if (board[i][j] == 2) {
                        startX = i;
                        startY = j;
                    } else if (board[i][j] == 3) {
                        arrivalX = i;
                        arrivalY = j;
                    }
                }
            }

            Deque<int[]> dq = new ArrayDeque<>();
            dq.add(new int[]{startX, startY});
            boolean[][] visited = new boolean[16][16];

            visited[startX][startY] = true;
            while (!dq.isEmpty()) {
                int[] now = dq.remove();
                if (now[0] == arrivalX && now[1] == arrivalY) {
                    result = 1;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (isRange(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dq.add(new int[]{nx, ny});
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < 16 && y >= 0 && y < 16 && board[x][y] != 1;
    }
}

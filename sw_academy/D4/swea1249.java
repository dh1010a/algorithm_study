package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class swea1249 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            System.out.println("dp = " + dp);

            Deque<Node> dq = new ArrayDeque<>();

            dq.add(new Node(0, 0, 0));
            while (!dq.isEmpty()) {
                Node now = dq.remove();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (isRange(N, nx, ny)) {
                        if (now.sum + map[nx][ny] < dp[nx][ny]) {
                            dq.add(new Node(nx, ny, now.sum + map[nx][ny]));
                            dp[nx][ny] = now.sum + map[nx][ny];
                        }
                    }

                }
            }
            System.out.println("#" + tc + " " + dp[N-1][N-1]);

        }
    }

    public static boolean isRange(int N, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static class Node{
        int x;
        int y;
        int sum;

        public Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
}

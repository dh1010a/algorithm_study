package D4;

import java.io.*;
import java.util.*;

public class swea2819 {

    static int[][] board;
    static Set<Integer> result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            board = new int[4][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(7, "", i, j);
                }
            }


            System.out.println("#" + tc + " " );
        }
    }

    static void dfs(int limit, String now, int x, int y) {
        if (now.length() == limit) {
            result.add(Integer.parseInt(now));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx, ny)) {
                dfs(limit, now + board[nx][ny], nx, ny);
            }
        }

    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

}

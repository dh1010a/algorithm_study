package D4;

import java.util.*;
import java.io.*;

class swea1861 {

    static int[][] map;
    static int N, maxRoom, maxMove;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            maxRoom = Integer.MAX_VALUE;
            maxMove = 0;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Deque<Node> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dq.add(new Node(i, j, map[i][j], 1));
                    while (!dq.isEmpty()) {
                        Node now = dq.remove();
                        if (maxMove < now.cnt) {
                            maxMove = now.cnt;
                            maxRoom = now.startRoom;
                        } else if (maxMove == now.cnt && maxRoom > now.startRoom) {
                            maxRoom = now.startRoom;
                        }

                        for (int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];

                            if (isRange(nx, ny) && map[nx][ny] == map[now.x][now.y] + 1) {
                                dq.add(new Node(nx, ny, now.startRoom, now.cnt + 1));
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + maxRoom  + " " + maxMove);
        }
    }

    public static class Node{
        int x;
        int y;
        int startRoom;
        int cnt;

        public Node(int x, int y, int startRoom, int cnt) {
            this.x = x;
            this.y = y;
            this.startRoom = startRoom;
            this.cnt = cnt;
        }
    }

//    public static int bfs(int x, ) {
//
//    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }


}

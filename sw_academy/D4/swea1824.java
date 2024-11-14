package D4;

import java.util.*;
import java.io.*;

class swea1824 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][][][] visited;
    static char[][] command;
    static int result, R, C;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            visited = new boolean[R][C][4][16];
            command = new char[R][C];
            result = -1;

            for (int i = 0; i < R; i++) {
                String str = br.readLine();
                for (int j = 0; j < C; j++) {
                    command[i][j] = str.charAt(j);
                    if (command[i][j] == '@') {
                        result = 0;
                    }
                }
            }

            if (result == 0)
                dfs(0, 0, 0, 0);

            if (result == 1) {
                System.out.println("#" + tc + " " + "YES");
            } else {
                System.out.println("#" + tc + " " + "NO");
            }
        }
    }

    static void dfs(int x, int y, int dir, int memory) {
        if (result != 0) {
            return;
        }
        if (visited[x][y][dir][memory]) {
            return;
        }

        visited[x][y][dir][memory] = true;
        char oper = command[x][y];

        if (oper >= '0' && oper <= '9') {
            memory = oper - '0';
        } else if (oper == '<') {
            dir = 2;
        } else if (oper == '>') {
            dir = 0;
        } else if (oper == 'v') {
            dir = 1;
        } else if (oper == '^') {
            dir = 3;
        } else if(oper == '_') {
            dir = (memory == 0) ? 0 : 2;
        } else if(oper == '|') {
            dir = (memory == 0) ? 1 : 3;
        }
        else if (oper == '?') {
            for (int i = 0; i < 4; i++) {
                int nextDir = (dir + i) % 4;
                int nx = x + dx[nextDir];
                int ny = y + dy[nextDir];

                if (nx < 0) nx = R - 1;
                else if (nx >= R) nx =  0;
                else if (ny < 0) ny = C - 1;
                else if (ny >= C) ny =  0;

                dfs(nx, ny, nextDir, memory);
            }
            return ;
        } else if (oper == '@') {
            result = 1;
        } else if(oper == '+') {
            memory = (memory == 15) ? 0 : memory + 1;
        } else if(oper == '-') {
            memory = (memory == 0) ? 15 :memory - 1;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0) nx = R - 1;
        else if (nx >= R) nx =  0;
        else if (ny < 0) ny = C - 1;
        else if (ny >= C) ny =  0;

        dfs(nx, ny, dir, memory);
    }


}
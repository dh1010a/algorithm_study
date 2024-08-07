import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, M, answer, zeroCnt;
    static List<Node> virus;
    static Node[] nowSelect;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        virus = new ArrayList<>();
        nowSelect = new Node[M];


        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) map[i][j] = -1;
                else if (map[i][j] == 2) {
                    map[i][j] = -2;
                    virus.add(new Node(i, j));
                }
                else zeroCnt++;
            }
        }

        dfs(0, 0);
        
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            answer = Math.min(afterVirus(), answer);
            return;
        }

        for(int i = start; i < virus.size(); i++) {
            nowSelect[cnt] = virus.get(i);
            dfs(i + 1, cnt + 1);
        }

    }

    public static int[][] copyArr() {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j =0 ; j < N; j++) {
                tmp[i][j] = map[i][j];
            }
        }
		return tmp;
    }

    static int afterVirus() {
        Deque<Node> q = new ArrayDeque<>();
        int[][] tmp = copyArr();
        boolean[][] visited = new boolean[N][N];

        for (Node x : nowSelect) {
            if (tmp[x.x][x.y] == -2) {
                q.addFirst(x);
                visited[x.x][x.y] = true;
                tmp[x.x][x.y] = 0;
            }
        }
        
        
        int nowCnt = 0;
        while (!q.isEmpty()) {
            Node now = q.pollLast();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && tmp[nx][ny] != -1 && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        nowCnt++;
                    }
                    q.addFirst(new Node(nx, ny));
                    visited[nx][ny] = true;
                    tmp[nx][ny] = tmp[now.x][now.y] + 1;
                }
            }

        }

        if (zeroCnt != nowCnt) {
            return Integer.MAX_VALUE;
        }
        return check(tmp);
    }

    public static int check(int[][] tmp) {
        int now_max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -2) tmp[i][j] = 0;
                now_max = Math.max(now_max, tmp[i][j]);
            }
        }
        
        return now_max;
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

     static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

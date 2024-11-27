import java.util.*;
import java.io.*;

class Main {
    static boolean[][][][] visited;
    static int[][] board;
    static int N, M;
    static Node end;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        Node red = null, blue = null;
        end = null;

        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == '#') {
                    board[i][j] = -1;
                } else if (row.charAt(j) == '.') {
                    board[i][j] = 0;
                } else if (row.charAt(j) == 'R') {
                    red = new Node(i, j, 1);
                    board[i][j] = 0;
                } else if (row.charAt(j) == 'B') {
                    blue = new Node(i, j, 1);
                    board[i][j] = 0;
                } else {
                    end = new Node(i, j, 0);
                    board[i][j] = 1;
                }
            }
        }
        System.out.println(bfs(red, blue));
        
        br.close();
	}

    public static int bfs(Node red, Node blue) {
        Deque<Node[]> dq = new ArrayDeque<>();
        visited[red.x][red.y][blue.x][blue.y] = true;
        dq.add(new Node[]{red, blue});
        while (!dq.isEmpty()) {
            Node[] now = dq.remove();
            Node nowRed = now[0];
            Node nowBlue = now[1];

            if (red.cnt > 10) {
                return 0;
            }
            if (isEnd(nowRed.x, nowRed.y)) {
                return 1;
            }

            for (int i = 0; i < 4; i++) {

            }
        }

    }

    public boolean move(int direction, Node red, Node blue) {
        if ()
    }

    public static boolean isMovable(int x, int y) {
        return board[x][y] != -1;
    }

    public static boolean isEnd(int x, int y) {
        return x == end.x && y == end.y;
    }

    public static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
   
}
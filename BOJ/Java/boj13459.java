import java.io.*;
import java.util.*;

public class Main {
    static char[][] maps;
    static int N, M;
    static boolean[][][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Node end;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        maps = new char[N][M];
        visited = new boolean[N][M][N][M];

        Node red = null;
        Node blue = null;
        end = null;
        
        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < M; j++) {
                maps[i][j] = tmp.charAt(j);
                if (tmp.charAt(j) != '#') maps[i][j] = '.';
                if (tmp.charAt(j) == 'R') red = new Node(i, j, 1);
                if (tmp.charAt(j) == 'B') blue = new Node(i, j, 1);
                if (tmp.charAt(j) == 'O') end = new Node(i, j, 0);
            }
        }
        
        bw.write(bfs(red, blue) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(Node r, Node b) {
        Deque<Node[]> q = new ArrayDeque<>();
        q.addFirst(new Node[]{r, b});
        visited[r.x][r.y][b.x][b.y] = true;

        while (!q.isEmpty()) {
            Node[] now = q.pollLast();
            Node red = now[0];
            Node blue = now[1];

            if (red.depth > 10) {
                return 0;
            }
            if (red.x == end.x && red.y == end.y) {
                return 1;
            }
            for (int i = 0; i < 4; i++) {
                Node newRed = new Node(red.x, red.y, red.depth+1);
                Node newBlue = new Node(blue.x, blue.y, blue.depth+1);
                if (move(dx[i], dy[i], newRed, newBlue)) {
                    if(isEnd(newRed.x, newRed.y)) return 1;
                    if(!visited[newRed.x][newRed.y][newBlue.x][newBlue.y]) {
                        visited[newRed.x][newRed.y][newBlue.x][newBlue.y] = true;
                        q.addFirst(new Node[]{newRed, newBlue});
                    }
                    
                }
            }
        }
        return 0;

    }

    public static boolean move(int directionX, int directionY, Node red, Node blue) {
        boolean firstRed = false;
        if (directionX == 0 && directionY == 1 && red.y > blue.y) firstRed = true;
        if (directionX == 1 && directionY == 0 && red.x > blue.x) firstRed = true;
        if (directionX == 0 && directionY == -1 && red.y < blue.y) firstRed = true;
        if (directionX == -1 && directionY == 0 && red.x < blue.x) firstRed = true;
        
        while (true) {
            int rnx = red.x + directionX;
            int rny = red.y + directionY;
            if (isPossible(rnx, rny)) {
                red.x = rnx;
                red.y = rny;
                if (isEnd(rnx, rny)) break;
            } else {
                break;
            }
        }
        
        while (true) {
            int bnx = blue.x + directionX;
            int bny = blue.y + directionY;
            if (isPossible(bnx, bny)) {
                blue.x = bnx;
                blue.y = bny;
                if (isEnd(bnx, bny)) break;
            } else {
                break;
            }
        }

        if (isEnd(blue.x, blue.y)) return false;

        if (red.x == blue.x && red.y == blue.y) {
            if (firstRed) {
                blue.x -= directionX;
                blue.y -= directionY;
            } else {
                red.x -= directionX;
                red.y -= directionY;
            }
        }
        return true;
    }

    public static boolean isPossible(int x, int y) {
        return maps[x][y] == '.';
    }

    public static boolean isEnd(int x, int y) {
        return (end.x == x && end.y == y);
    }

    static class Node {
        int x;
        int y;
        int depth;
        
        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer;
	static int[][] world;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Node> queue;
    


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		world = new int[N][M];
        answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        dfs(0);

        bw.write(answer + "\n");


        br.close();
        bw.flush();
        bw.close();
    }

    public static int[][] copyArr() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = world[i].clone();
        }
		return temp;
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            afterVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (world[i][j] == 0) {
                    world[i][j] = 1;
                    dfs(cnt + 1);
                    world[i][j] = 0;
                }
            }
        }
    }

    public static void afterVirus() {
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (world[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        int[][] temp = copyArr();

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (isPuttable(nx, ny, temp)) {
                    temp[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        checkSafe(temp);
    }

    public static void checkSafe(int[][] temp) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.max(answer, cnt);
    }

    public static boolean isPuttable(int x, int y, int[][] temp) {
        return x >= 0 && x < N & y >= 0 && y < M && temp[x][y] == 0;
    }

}

class Node{
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

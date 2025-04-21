import java.io.*;
import java.util.*;

public class boj2638 {
	static int N, M, answer;
	static int[][] world;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cheezeCount;
    static boolean[][] visited;
    


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        world = new int[N][M];
        answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        while (true) {
            visited = new boolean[N][M];
            checkAir(0, 0);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (world[i][j] == 1) {
                        checkMelt(i, j);
                    }
                }
            }
            int remainCheeze = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (world[i][j] == 1) {
                        remainCheeze++;
                    }
                    if (world[i][j] == 2) {
                        world[i][j] = 0;
                    }
                }
            }
            answer++;
            if (remainCheeze == 0) {
                break;
            }
        }
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void checkMelt(int x, int y) {
        int count = 0;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (isValid(nx, ny) && world[nx][ny] == 3) {
                count++;
            }
        }
        // 녹은 치즈는 2로 표시 (나중에 지우기)
        if (count >= 2) {
            world[x][y] = 2;
        }
    }

    //외부 공기와 접촉한 공기는 3으로 표시
    static void checkAir(int x, int y) {
        visited[x][y] = true;
        world[x][y] = 3;
    
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
    
            if (!isValid(nx, ny)) continue;
            if (visited[nx][ny] || world[nx][ny] == 1 || world[nx][ny] == 2) continue;
    
            checkAir(nx, ny);
        }
    }

    public static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}
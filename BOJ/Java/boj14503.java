import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj14503 {

	static int answer;
	static int N, M;
	static int[][] map;
	static int[] robot;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		robot = new int[3];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 3; i++) {
			robot[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {

			if (map[robot[0]][robot[1]] == 0) {
				answer++;
				map[robot[0]][robot[1]] = 2;
			}

			boolean blankExist = false;

			for (int i = 0; i < 4; i++) {
				int nx = robot[0] + dx[i];
				int ny = robot[1] + dy[i];
				if (isPossible(nx, ny) && map[nx][ny] == 0) {
					blankExist = true;
				}
			}
			if (!blankExist) {
				int back_idx = (robot[2] + 2) % 4;

				int nx = robot[0] + dx[back_idx];
				int ny = robot[1] + dy[back_idx];

				if (isPossible(nx, ny)) {
					robot[0] = nx;
					robot[1] = ny;
				} else break;
			} else {
				robot[2] = (robot[2] + 4 - 1) % 4;
				int nx = robot[0] + dx[robot[2]];
				int ny = robot[1] + dy[robot[2]];
				if (isPossible(nx, ny) && map[nx][ny] == 0) {
					robot[0] = nx;
					robot[1] = ny;
				}
			}
		}

		System.out.println(answer);
	}

	public static boolean isPossible(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 1;
	}
}

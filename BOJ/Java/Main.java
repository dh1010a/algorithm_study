import java.util.*;
import java.io.*;

class Main {

	static int[][] map;
	static int[] shark;
	static int N;

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	static int minX, minY, minDist;



	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int answer = 0;

		// 맵과 물고기, 상어의 위치 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new int[]{i, j, 2, 0}; // x, y, size, 먹은 마리 수
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				if (o1[2] == o2[2]) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					} else {
						return o1[0] - o2[0];
					}
				} else {
					return o1[2] - o2[2];
				}
			});
			pq.add(new int[]{shark[0], shark[1], 0});
			boolean isEat = false;
			boolean[][] visited = new boolean[N][N];

			while (!pq.isEmpty()) {
				int[] now = pq.poll();

				if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] < shark[2]) {
					isEat = true;
					shark[0] = now[0];
					shark[1] = now[1];
					shark[3]++;

					map[now[0]][now[1]] = 0;
					if (shark[2] == shark[3]) {
						shark[2]++;
						shark[3] = 0;
					}
					answer += now[2];
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];
					if (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] <= shark[2]) {
						pq.add(new int[]{nx, ny, now[2] + 1});
						visited[nx][ny] = true;
					}
				}
			}
			if (!isEat) {
				break;
			}
		}

		System.out.println(answer);
	}


	private static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}

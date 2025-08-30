import java.util.*;

class pgs250136 {

	int[][] map;
	int r, c;
	int[] dx = {1, 0, -1, 0};
	int[] dy = {0, 1, 0, -1};
	int[] dp;

	boolean[][] visited;

	public int solution(int[][] land) {
		int answer = 0;
		this.map = land;
		r = map.length;
		c = map[0].length;
		dp = new int[c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					Set<Integer> sets = new HashSet<>();
					int nowSum = checkSum(i, j, sets);
					for (int x : sets) {
						dp[x] += nowSum;
					}
				}
			}
		}


		return Arrays.stream(dp).max().getAsInt();
	}

	public int checkSum(int x, int y, Set<Integer> sets) {
		int sum = 0;

		Deque<int[]> dq = new ArrayDeque<>();

		dq.add(new int[]{x, y, 1});

		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			sets.add(now[1]);
			sum++;

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (isPossible(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dq.add(new int[]{nx, ny});
				}

			}
		}
		return sum;

	}


	public boolean isPossible(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c && map[x][y] != 0;
	}
}
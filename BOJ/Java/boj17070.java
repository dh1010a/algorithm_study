import java.util.*;
import java.io.*;

class boj17070 {

	private static int N;
	private static int[][] map;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Deque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[]{0, 0, 0, 1});
//		visited[0][1][0][0] = true;

		while (!dq.isEmpty()) {
			int[] now = dq.remove();

			int x1 = now[0], y1 = now[1], x2 = now[2], y2 = now[3];
			// 도착시
			if (x2 == N - 1 && y2 == N - 1) {
				answer++;
				continue;
			}
			// 대각선으로 밀기
			if (isRange(x2 + 1, y2 + 1) && map[x2][y2 + 1] == 0 && map[x2+1][y2] == 0 && map[x2 + 1][y2 + 1] == 0) {
				dq.add(new int[]{x2, y2, x2 + 1, y2 + 1});
			}
			// 세로로 놓여있을때
			if (Math.abs(x1 - x2) == 1){
				if (isRange(x2 + 1, y2) && map[x2 + 1][y2] == 0) {
					dq.add(new int[]{x2, y2, x2 + 1, y2});
				}
			} // 가로로 놓여있을 떄
			if (Math.abs(y1 - y2) == 1){
				if (isRange(x2, y2 + 1) && map[x2][y2+1] == 0) {
					dq.add(new int[]{x2, y2, x2, y2 + 1});
				}
			}
		}
		System.out.println(answer);

	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}


}


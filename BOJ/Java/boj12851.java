import java.util.*;
import java.io.*;

public class boj12851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] visited = new int[100001];
		int cnt = 0;

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Arrays.fill(visited, 100001);
		visited[N] = 0;

		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(N);

		while (!dq.isEmpty()) {
			int now = dq.poll();

			if (now == K) {
				cnt++;
				continue;
			}

			int[] tmp = new int[]{now - 1, now + 1, now * 2};
			for (int x : tmp) {
				if (x < visited.length && x >= 0 && visited[x] >= visited[now] + 1) {
					visited[x] = visited[now] + 1;
					dq.add(x);
				}
			}
		}
		System.out.println(visited[K]);
		System.out.println(cnt);
	}
}
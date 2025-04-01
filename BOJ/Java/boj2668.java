import java.util.*;
import java.io.*;

public class boj2668 {

	static int N;
	static int[] array;
	static boolean[] visited;
	static List<Integer> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		array = new int[N + 1];
		visited = new boolean[N + 1];
		answer = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}

		Collections.sort(answer);
		System.out.println(answer.size());
		for (int x : answer) {
			System.out.println(x);
		}
	}

	static void dfs(int start, int target) {
		if (!visited[array[start]]) {
			visited[array[start]] = true;
			dfs(array[start], target);
			visited[array[start]] = false;
		}
		if (array[start] == target) {
			answer.add(target);
		}
	}
}
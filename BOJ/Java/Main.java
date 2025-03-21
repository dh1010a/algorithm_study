import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> belt = new ArrayList<>();
		List<Integer> robot = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N * 2; i++) {
			belt.add(Integer.parseInt(st.nextToken()));
			robot.add(0);
		}


		int zeroCnt = 0;
		int answer = 0;
		while (zeroCnt < K) {

			belt.add(0, belt.remove(belt.size() - 1));
			robot.add(0, robot.remove(robot.size() - 1));

			if (robot.get(N - 1) != 0) {
				robot.set(N - 1, 0);
			}

			for (int i = N * 2 - 1; i >= 0; i--) {
				if (robot.get(i) == 1) {
					if (i == N * 2 - 1) {
						robot.set(i, 0);
					} else {
						if (belt.get(i + 1) != 0 && robot.get(i + 1) == 0) {
							belt.set(i + 1, belt.get(i + 1) - 1);
							robot.set(i, 0);
							robot.set(i + 1, 1);
							if (belt.get(i + 1) == 0) {
								zeroCnt++;
							}
						}
					}
				}
			}
			if (robot.get(N - 1) != 0) {
				robot.set(N - 1, 0);
			}

			if (robot.get(0) != 1 && belt.get(0) != 0) {
				belt.set(0, belt.get(0) - 1);
				robot.set(0, 1);
				if (belt.get(0) == 0) {
					zeroCnt++;
				}
			}

			answer++;

		}

		System.out.println(answer);
	}
}
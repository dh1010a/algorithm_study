import java.util.*;
import java.io.*;

class boj1715 {

	static PriorityQueue<Integer> pq;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();

		int answer = 0;

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (pq.size() > 1) {
			int c1 = pq.poll();
			int c2 = pq.poll();

			pq.add(c1 + c2);
			answer += c1 + c2;
		}

		System.out.println(answer);

	}


}

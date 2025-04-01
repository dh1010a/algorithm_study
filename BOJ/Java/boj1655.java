import java.util.*;
import java.io.*;

public class boj1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];

		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int next = Integer.parseInt(br.readLine());

			if (left.isEmpty() || next <= left.peek()) {
				left.add(next);
			} else {
				right.add(next);
			}

			if (left.size() > right.size() + 1) {
				right.add(left.poll());
			} else if (right.size() > left.size() + 1) {
				left.add(right.poll());
			}

			if (right.size() == left.size()) {
				answer[i] = Math.min(left.peek(), right.peek());
			} else {
				answer[i] = left.size() > right.size() ? left.peek() : right.peek();
			}


		}

		for (int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}

	}
}
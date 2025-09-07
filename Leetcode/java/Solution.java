import java.util.*;

class Solution {
	public int trap(int[] height) {
		Deque<Node> dq = new ArrayDeque<>();
		int[] trap = height.clone();
		int answer = 0;

		Node now = new Node(0, 0);

		for (int i = 0; i < height.length; i++) {
			int h = height[i];

			while (!dq.isEmpty() && h >= dq.peekLast().h) {
				now = dq.removeLast();
			}

			Node left;

			if (dq.isEmpty()) {
				left = now;
				for (int j = left.idx + 1; j < i; j++) {
					trap[j] = left.h;
				}
			} else {
				left = dq.peekLast();
				for (int j = left.idx + 1; j < i; j++) {
					trap[j] = h;
				}

			}

			dq.add(new Node(height[i], i));
		}

		for (int i = 0; i < height.length; i++) {
			answer += trap[i] - height[i];
		}
		return answer;
	}

	class Node {
		int h;
		int idx;

		public Node(int h, int idx) {
			this.h = h;
			this.idx = idx;
		}
	}
}
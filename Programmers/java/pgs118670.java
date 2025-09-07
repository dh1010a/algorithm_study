import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class pgs118670 {

	private int r, c;


	public int[][] solution(int[][] rc, String[] operations) {
		r = rc.length;
		c = rc[0].length;

		Deque<Integer> start = new ArrayDeque<>();
		Deque<Deque<Integer>> mid = new ArrayDeque<>();
		Deque<Integer> end = new ArrayDeque<>();

		for (int i = 0; i < r; i++) {
			start.add(rc[i][0]);
			Deque<Integer> dq = new ArrayDeque<>();
			for (int j = 1; j < c - 1; j++) {
				dq.add(rc[i][j]);
			}
			mid.add(dq);
			end.add(rc[i][c - 1]);
		}

		for (String op : operations) {
			if (op.equals("Rotate")) {
				mid.getFirst().addFirst(start.remove());
				end.addFirst(mid.getFirst().removeLast());
				mid.getLast().add(end.removeLast());
				start.add(mid.getLast().remove());
			} else {
				start.addFirst(start.removeLast());
				mid.addFirst(mid.removeLast());
				end.addFirst(end.removeLast());
			}
		}

		for (int i = 0; i < r; i++) {
			rc[i][0] = start.remove();

			Deque<Integer> dq = mid.remove();
			for (int j = 1; j < c - 1; j++) {
				rc[i][j] = dq.remove();
			}

			rc[i][c - 1] = end.remove();
		}

		return rc;
	}


}
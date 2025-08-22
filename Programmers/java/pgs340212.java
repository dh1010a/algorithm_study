import java.util.*;

class pgs340212 {

	int answer;

	public int solution(int[] diffs, int[] times, long limit) {
		answer = Integer.MAX_VALUE;

		int left = 1;
		int right = 100001;

		while (left < right) {
			int mid = (left + right) / 2;

			if (isPossible(diffs, times, limit, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}

		}

		return answer;
	}

	public boolean isPossible(int[] diffs, int[] times, long limit, int level) {
		long time = 0;
		for (int i = 0; i < diffs.length; i++) {
			if (time > limit) {
				return false;
			}
			if (diffs[i] <= level) {
				time += times[i];
			} else {
				time += (diffs[i] - level) * (times[i - 1] + times[i]);
				time += times[i];
			}
		}


		if (time <= limit) {
			answer = Math.min(level, answer);
			return true;
		} else {
			return false;
		}
	}
}
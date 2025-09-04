import java.util.*;

class pgs178870 {
	public int[] solution(int[] sequence, int k) {
		int[] answer = {0, 1_000_000};
		int sum = 0;
		int start = 0;

		for (int end = 0; end < sequence.length; end++) {
			sum += sequence[end];

			while (sum > k) {
				sum -= sequence[start];
				start++;
			}

			if (sum == k && end - start < answer[1] - answer[0]) {
				answer[0] = start;
				answer[1] = end;
			}


		}

		return answer;
	}
}
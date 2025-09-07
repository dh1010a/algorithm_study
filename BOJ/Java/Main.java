import java.util.*;
class Solution {

	long answer = 0;

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {

		for (int i = n - 1; i >= 0; ) {

			if (deliveries[i] == 0 && pickups[i] == 0) {
				i--;
				continue;
			}

			calculate(cap, deliveries, i);
			calculate(cap, pickups, i);

			answer += (i + 1) * 2;
		}
		return answer;
	}

	private void calculate(int cap, int[] arr, int idx) {

		while (idx >= 0) {
			if (cap >= arr[idx]) {
				cap -= arr[idx];
				arr[idx] = 0;
				idx--;
			} else {
				arr[idx] -= cap;
				break;
			}
		}
	}
}
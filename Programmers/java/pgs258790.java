import java.util.*;

class pgs258790 {

	private int n;
	private int[] answer;
	private int[][] dice;
	private List<Integer> aSums;
	private List<Integer> bSums;
	private int maxCount = Integer.MIN_VALUE;

	private void makeSumList(List<Integer> dices, List<Integer> sums, int depth, int sum) {
		if (depth == n / 2) {
			sums.add(sum);
			return;
		}
		for (int i = 0; i < 6; i++) {
			makeSumList(dices, sums, depth + 1, sum + dice[dices.get(depth)][i]);
		}
	}

	private int calculate(List<Integer> aDices) {
		List<Integer> bDices = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!aDices.contains(i)) {
				bDices.add(i);
			}
		}
		aSums = new ArrayList<>();
		bSums = new ArrayList<>();

		makeSumList(aDices, aSums, 0, 0);
		makeSumList(bDices, bSums, 0, 0);

		int count = 0;

		Collections.sort(bSums);
		for (int i = 0; i < aSums.size(); i++) {
			int number = aSums.get(i);

			int left = 0, right = bSums.size()-1;
			int index = Integer.MIN_VALUE;
			while (left <= right) {
				int mid = (left + right) / 2;

				if (bSums.get(mid) < number) {
					left = mid + 1;
					index = Math.max(index, mid);

				} else {
					right = mid - 1;
				}
			}
			if (index != Integer.MIN_VALUE) {
				count += index + 1;
			}
		}
		return count;
	}

	private void makeComb(List<Integer> aDices, int depth, int last) {
		if (depth == n / 2) {
			int result = calculate(aDices);
			if (result > maxCount) {
				answer = aDices.stream().mapToInt(i -> i + 1).toArray();
				Arrays.sort(answer);
				maxCount = result;
			}
			return;
		}
		for (int i = last; i < n; i++) {
			aDices.add(i);
			makeComb(aDices, depth + 1, i + 1);
			aDices.remove(aDices.size() - 1);
		}
	}


	public int[] solution(int[][] dice) {
		n = dice.length;
		answer = new int[n / 2];
		this.dice = dice;

		makeComb(new ArrayList<>(), 0, 0);

		return answer;
	}
}

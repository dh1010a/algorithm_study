import java.util.*;

class pgs172927 {

	private int answer;
	private int[][] cost = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

	public int solution(int[] picks, String[] minerals) {
		answer = Integer.MAX_VALUE;

		find(picks, minerals, 0, 0);
		return answer;
	}

	public void find(int[] picks, String[] minerals, int depth, int fatigue) {
		int left = 0;
		for (int i = 0; i < picks.length; i++) {
			left += picks[i];
		}

		if (depth == minerals.length || left == 0) {

			answer = Math.min(fatigue, answer);
			return;
		}
		int dest = Math.min(minerals.length, depth + 5);
		for (int i = 0; i < 3; i++) {
			if (picks[i] == 0) continue;
			picks[i]--;
			int now_fatigue = fatigue;

			for (int j = depth; j < dest; j++) {
				now_fatigue += cost[i][getMineralIdx(minerals[j])];
			}
			find(picks, minerals, dest, now_fatigue);
			picks[i]++;
		}
	}

	private int getMineralIdx(String str) {
		if (str.equals("diamond")) return 0;
		if (str.equals("iron")) return 1;
		if (str.equals("stone")) return 2;
		return -1;
	}
}
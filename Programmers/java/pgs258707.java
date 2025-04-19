import java.util.*;

class pgs258707 {

	boolean[] hand;
	boolean[] free;
	int N;

	public int solution(int coin, int[] cards) {
		int answer = 1;
		N = cards.length;

		hand = new boolean[N + 1];
		free = new boolean[N + 1];

		for(int i = 0; i < N / 3; i++) {
			hand[cards[i]] = true;
			free[cards[i]] = true;
		}

		for (int i = N / 3; i < N; i += 2) {
			if (coin > 0) {
				hand[cards[i]] = true;
				hand[cards[i+1]] = true;
			}

			boolean pass = false;
			int minCost = 3;
			int dropCard = -1;
			for (int j = 1; j <= N/2; j++) {
				if (!hand[j]) {
					continue;
				}

				if (hand[N + 1 - j]) {
					int cost = (free[j] ? 0 : 1) + (free[N + 1 -j] ? 0 : 1);
					if (coin < cost || minCost <= cost) {
						continue;
					}
					pass = true;
					dropCard = j;
					minCost = cost;
				}
			}

			if (!pass) {
				break;
			}
			hand[dropCard] = false;
			hand[N + 1 - dropCard] = false;
			coin -= minCost;

			answer++;
		}
		return answer;
	}
}
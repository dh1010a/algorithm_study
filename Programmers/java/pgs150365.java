import java.util.*;

class pgs150365 {

	int[] dx = {1, 0, 0, -1};
	int[] dy = {0, -1, 1, 0};
	String[] dir = {"d", "l", "r", "u"};
	int n, m;

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		this.n = n;
		this.m = m;

		StringBuilder sb = new StringBuilder();

		return dfs(r, c, x, y, k, sb) ? sb.toString() : "impossible";
	}

	public boolean dfs(int r, int c, int x, int y, int k, StringBuilder now) {
		if (now.length() == k) {
			if (x == r && y == c) {
				return true;
			}
		}

		int remain = k - now.length();
		int distance = Math.abs(x - r) + Math.abs(y - c);

		// 가지치기: 남은 거리보다 많이 이동해야 하거나, 도달 가능성이 없는 경우
		if (remain < distance || (remain - distance) % 2 != 0) {
			return false;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isRange(nx, ny)) {
				now.append(dir[i]);
				if (dfs(r, c, nx, ny, k,  now)) {
					return true;
				}
				now.deleteCharAt(now.length() - 1);
			}
		}

		return false;
	}

	public boolean isRange(int x, int y) {
		return x >= 1 && x <= n && y >= 1 && y <= m;
	}

}
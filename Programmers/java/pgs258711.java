import java.util.*;

public class pgs258711 {

	boolean[] visited;
	int[] answer;
	Map<Integer, List<Integer>> map;
	Map<Integer, Integer> inbound_cnt;

	public int[] solution(int[][] edges) {
		answer = new int[4];
		int node_cnt = 0;

		map = new HashMap<>();
		inbound_cnt = new HashMap<>();

		for (int[] edge : edges) {
			node_cnt = Math.max(node_cnt, Math.max(edge[0], edge[1]));
			map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
			inbound_cnt.put(edge[1], inbound_cnt.getOrDefault(edge[1], 0) + 1);
		}
		visited = new boolean[node_cnt + 1];

		// 각 그래프별 임의의 정점 집합
		List<Integer> startPoint = new ArrayList<>();

		// 새로 생성된 정점을 찾고, 제거
		for (int x : map.keySet()) {
			if (inbound_cnt.get(x) == null && map.get(x).size() >= 2) {
				startPoint.addAll(map.get(x));
				map.remove(x);
				answer[0] = x;
				break;
			}
		}

		for (int node : startPoint) {
			inbound_cnt.put(node, inbound_cnt.get(node) - 1);
			if (!visited[node]) {
				answer[checkGraph(node)]++;
			}
		}


		return answer;
	}

	// 도넛 1, 막대 2, 8자 3
	public int checkGraph(int node) {
		Deque<Integer> dq = new ArrayDeque<>();
		visited[node] = true;
		dq.add(node);

		while (!dq.isEmpty()) {
			int now = dq.poll();
			if (map.get(now) == null) { // 막대인 경우
				return 2;
			} else if (inbound_cnt.get(now) == 2 && map.get(now).size() == 2) { // 8인 경우
				return 3;
			} else {
				for (int x : map.get(now)) {
					if (!visited[x]) {
						dq.add(x);
						visited[x] = true;
					}
				}
			}
		}
		return 1;
	}

}

import java.util.*;

class leet1514 {

	Map<Integer, List<Edge>> graph;
	double[] probs;

	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		graph = new HashMap<>();
		probs = new double[n];

		for (int i = 0; i < edges.length; i++) {
			graph.putIfAbsent(edges[i][0], new ArrayList<>());
			graph.putIfAbsent(edges[i][1], new ArrayList<>());
			graph.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
			graph.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));
		}

		PriorityQueue<Edge> pq = new PriorityQueue();

		pq.add(new Edge(start_node, 1.0));
		probs[start_node] = 1.0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();

			if (now.x == end_node) {
				return now.weight;
			}

			if (!graph.containsKey(now.x)) {
				continue;
			}

			for (Edge edge : graph.get(now.x)) {
				double nextWeight = now.weight * edge.weight;
				if (nextWeight > probs[edge.x]) {
					probs[edge.x] = nextWeight;
					pq.add(new Edge(edge.x, nextWeight));
				}
			}

		}

		return probs[end_node];

	}

	class Edge implements Comparable<Edge> {
		int x;
		double weight;

		public Edge(int x, double weight) {
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge diff) {
			return Double.compare(diff.weight, this.weight);
		}
	}
}
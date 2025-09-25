import java.util.*;

class pgs118669 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        Set<Integer> summitSet = new HashSet<>();
        for (int x : summits) {
            summitSet.add(x);
        }

        for (int[] path : paths) {
            graph.putIfAbsent(path[0], new LinkedList<>());
            graph.putIfAbsent(path[1], new LinkedList<>());

            graph.get(path[0]).add(new Edge(path[1], path[2]));
            graph.get(path[1]).add(new Edge(path[0], path[2]));
        }

        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, 10_000_001);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int start : gates) {
            pq.add(new Edge(start, 0));
            intensities[start] = 0;
        }

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (summitSet.contains(now.node)|| now.intense > intensities[now.node]) continue;

            for (Edge next : graph.get(now.node)) {
                int nextIntense = Math.max(now.intense, next.intense);
                if (intensities[next.node] > nextIntense) {
                    intensities[next.node] = nextIntense;
                    pq.add(new Edge(next.node, nextIntense));
                }
            }
        }

        int[] answer = {500000, 10_000_001};
        for (int summit : summits) {
            if (answer[1] == intensities[summit]) {
                answer[0] = Math.min(answer[0], summit);
            } else if (answer[1] > intensities[summit]) {
                answer[0] = summit;
                answer[1] = intensities[summit];
            }
        }

        return answer;
    }


    class Edge implements Comparable<Edge>{

        int node;
        int intense;

        public Edge(int node, int intense) {
            this.node = node;
            this.intense = intense;
        }

        @Override
        public int compareTo(Edge diff) {
            return this.intense - diff.intense;
        }
    }

}
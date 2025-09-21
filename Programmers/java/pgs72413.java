import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class pgs72413 {


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];


        for (int[] x : fares) {
            graph[x[0]][x[1]] = x[2];
            graph[x[1]][x[0]] = x[2];
        }
        int[][] costs = new int[3][n + 1];
        for (int[] x : costs) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        int[] target = {s, a, b};
        for (int i = 0; i < 3; i++) {
            dq.add(new int[]{target[i], 0});
            costs[i][target[i]] = 0;
            while (!dq.isEmpty()) {
                int[] now = dq.poll();

                for (int j = 1; j < n + 1; j++) {
//					if (j == now[0]) continue;
                    if (graph[now[0]][j] == 0) continue;

                    if (costs[i][j] > now[1] + graph[now[0]][j]) {
                        costs[i][j] = now[1] + graph[now[0]][j];
                        dq.add(new int[]{j, costs[i][j]});
                    }
                }

            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;

            for (int j = 0; j < 3; j++) {
                sum += costs[j][i];
            }
            answer = Math.min(sum, answer);
        }


        return answer;
    }


}

// 플로이드 와샬 알고리즘

class Solution {


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1 ; i < n + 1; i++) {
            Arrays.fill(graph[i], 200 * 100_000);
            graph[i][i] = 0;
        }

        for (int[] x : fares) {
            graph[x[0]][x[1]] = x[2];
            graph[x[1]][x[0]] = x[2];
        }



        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }

                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }

        return answer;
    }


}
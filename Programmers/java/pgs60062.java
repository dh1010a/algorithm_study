import java.util.*;

class pgs60062 {

    int[] weak_circle, dist;
    int n, answer;

    public int solution(int n, int[] weak, int[] dist) {
        weak_circle = new int[weak.length * 2];
        answer = Integer.MAX_VALUE;
        this.dist = dist;
        this.n = n;

        for (int i = 0; i < weak.length; i++) {
            weak_circle[i] = weak[i];
            weak_circle[i + weak.length] = weak[i] + n;
        }

        for (int i = 0; i < weak.length; i++) {
            makeDistCase(i, 0, new boolean[dist.length], new int[dist.length]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public void makeDistCase(int start, int depth, boolean[] visited, int[] permutation) {
        if (depth == dist.length) {
            answer = Math.min(check(start, permutation), answer);
            return;
        }

        for (int i = 0; i < permutation.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = dist[i];
                makeDistCase(start, depth + 1, visited, permutation);
                visited[i] = false;
            }
        }
    }

    public int check(int start, int[] permutation) {
        int person = 1;
        int pos = weak_circle[start] + permutation[person-1];
        for (int i = start; i < start + weak_circle.length/2; i++) {
            if (pos < weak_circle[i]) {
                person++;
                if (person > permutation.length) {
                    return Integer.MAX_VALUE;
                }
                pos = weak_circle[i] + permutation[person - 1];
            }
        }
        return person;
    }


}

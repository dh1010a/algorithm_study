import java.util.*;

class Solution {

    boolean[] visited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(v -> v.equals(target))) {
            return 0;
        }
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String now, String target, String[] words, int cnt) {
        System.out.println("now = " + now);
        if (now.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int diff = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (words[i].charAt(j) != now.charAt(j)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }

}
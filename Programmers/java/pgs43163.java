class pgs43163 {
    boolean[] visited;
    int n, answer;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        n = words.length;
        visited = new boolean[n];
        dfs(begin, target, words, 0);
        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }

    public void dfs(String now, String target, String[] words, int cnt) {
        if (now.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int diff = 0;
                for (int j = 0; j < now.length(); j++) {
                    if (now.charAt(j) != words[i].charAt(j)) diff++;
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
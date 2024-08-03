class Solution {
    int[][] word;
    int answer;

    public int solution(int n) {
        answer = 0;
        word = new int[n][n];
        dfs(word, n, 0);
        return answer;
    }
    
    public boolean isPossible(int[][] word, int n, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                if (word[i][j] == 1) {
                    if (j == y || isDiagonal(x, y, i, j)) {
                        return false;
                    }
                }
            } 
        }
        return true;
    }
    
    public boolean isDiagonal(int x, int y, int x1, int y1) {
        return Math.abs(x1 -x) == Math.abs(y1 -y);
    }
    
    public void dfs(int[][] word, int n, int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isPossible(word, n, depth, i)) {
                word[depth][i] = 1;
                dfs(word, n, depth+1);
                word[depth][i] = 0;
            }
        } 
    }
}
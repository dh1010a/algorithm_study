class pgs12942 {
    int[][] matrix, dp;

    public int solution(int[][] matrix_sizes) {
        this.matrix = matrix_sizes;
        this.dp = new int[matrix.length + 1][matrix.length + 1];
        return find(0, matrix.length);
    }

    private int find(int s, int e) {
        if (dp[s][e] == 0)
            dp[s][e] = solve(s, e);
        return dp[s][e];
    }

    private int solve(int s, int e) {
        if (e - s == 1) return 0;

        int result = Integer.MAX_VALUE;
        for (int m = s + 1; m < e; m++) {
            int left = find(s, m);
            int right = find(m, e);
            int now = matrix[s][0] * matrix[m][0] * matrix[e-1][1];
            result = Math.min(result, now + left + right);
        }
        return result;
    }

}
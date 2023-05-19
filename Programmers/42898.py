def solution(m, n, puddles):
    answer = 0
    dp = [[0]*m for _ in range(n)]
    def is_range(x, y):
        return 0<=x<n and 0<=y<m and dp[x][y]>=0
    for i in puddles:
        dp[i[1]-1][i[0]-1] = -1
    dp[0][0] = 1
    for i in range(n):
        for j in range(m):
            dx, dy = i-1, j-1
            if i == 0 and j == 0 or dp[i][j] == -1:
                continue
            else:
                if is_range(dx, j):
                    dp[i][j] += dp[dx][j]
                if is_range(i, dy):
                    dp[i][j] += dp[i][dy]
    answer = dp[-1][-1] % 1000000007
    return answer
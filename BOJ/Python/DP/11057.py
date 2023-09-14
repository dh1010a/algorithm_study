n = int(input())
dp = [[1]*10 for i in range(n + 1)]

if n > 1:
    for i in range(2, n + 1):
        for j in range(10):
            tmp = 0
            for k in range(0, j + 1):
                tmp += dp[i-1][k]
            dp[i][j] = tmp
print(sum(dp[n])%10007)
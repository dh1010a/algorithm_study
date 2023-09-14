n = input()
ans = input()

dp = [[0 for _ in range(len(ans)+1)] for _ in range(len(n)+1)]

for i in range(len(n)+1):
    dp[i][0] = i
for i in range(len(ans)+1):
    dp[0][i] = i
for i in range(1, len(n)+1):
    for j in range(1, len(ans)+1):
        if n[i-1] == ans[j-1]:
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = min(dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1)
print(dp[-1][-1])
            
            
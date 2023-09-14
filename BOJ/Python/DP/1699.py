n = int(input())
dp = [i for i in range(n+1)]
value = [i*i for i in range(n+1)]
for i in range(n+1):
    for j in value:
        if j > i:
            break
        dp[i] = min(dp[i], dp[i-j]+1)
print(dp[n])

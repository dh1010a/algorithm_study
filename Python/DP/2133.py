n = int(input())
if n==1:
    print(0)
else:
    dp = [0 for i in range(n + 1)]
    dp[2] = 3
    for i in range(4, n+1):
        if i % 2 == 0:
            dp[i] = dp[i-2] * 3 + sum(dp[:i-2]) * 2 + 2

    print(dp[n])
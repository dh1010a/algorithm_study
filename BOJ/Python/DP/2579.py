n = int(input())
arr = [int(input()) for _ in range(n)]
dp = [0] * n
dp[0] = arr[0]
if n > 2:
    dp[1], dp[2] = arr[0] + arr[1], arr[0] + arr[2]
    for i in range(2, n):
        dp[i] = max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i])
else:
    if n == 2:
        dp[1] = arr[0] + arr[1]
print(dp[n-1])
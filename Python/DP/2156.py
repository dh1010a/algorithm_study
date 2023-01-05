n = int(input())
arr = [int(input()) for _ in range(n)]
dp = [0 for _ in range(n)]
dp[0] = arr[0]
if n >= 3:
    dp[1], dp[2] = arr[0] + arr[1], max(arr[0]+arr[1], arr[1]+arr[2], arr[0]+arr[2])
    for i in range(3, n):
        dp[i] = max(dp[i-3] + arr[i] + arr[i-1], dp[i-2] + arr[i])
        dp[i] = max(dp[i], dp[i-1])
else :
    if n == 2:
        dp[1] = arr[0] + arr[1]
print(dp[n-1])
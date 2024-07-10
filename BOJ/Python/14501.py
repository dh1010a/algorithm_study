import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

dp = [0] * (N+1)

for i in range(0, N+1):
    for j in range(0, i):
        dp[i] = max(dp[i], dp[j])
        if (j + arr[j][0] == i):
            dp[i] = max(dp[i], dp[j] + arr[j][1])
            
print(max(dp))
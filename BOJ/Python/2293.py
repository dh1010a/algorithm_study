import sys
input = sys.stdin.readline

N, T = map(int, input().split())

arr = []
for _ in range(N):
    arr.append(int(input()))
    
arr.sort()
dp = [0] * (T+1)

dp[0] = 1
for i in range(N):
    for j in range(arr[i], T+1):
            dp[j] += dp[j-arr[i]]
            
print(dp[T])

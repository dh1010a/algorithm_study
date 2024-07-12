import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

max_int = 1000 * 1000

answer = max_int

for k in range(3):
    dp = [[0] * 3 for _ in range(N)]
    dp[0][k] = arr[0][k]
    dp[0][(k+1) % 3] = max_int
    dp[0][(k+2) % 3] = max_int
    
    for i in range(1, N):
        for j in range(3):
            dp[i][j] = arr[i][j] + min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3])

    answer = min(min(dp[-1][(k+1) % 3], dp[-1][(k+2) % 3]), answer)

print(answer)
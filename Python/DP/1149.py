import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
dp = [[1001]*3 for i in range(n)]
dp[0] = arr[0]

for i in range(1, n):
    for j in range(3): #DP배열 세번 기록하기 위함
        dp[i][j] = min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + arr[i][j]
            
print(min(dp[n-1]))
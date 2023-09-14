import sys
input = sys.stdin.readline
INF = sys.maxsize
def solution(n, arr):
    sol_left = [i for i in range(n)]
    sol_right = [i for i in range(n)]
    for i in range(n):
        left = arr[i][0] - arr[i][1]
        right = arr[i][0] + arr[i][1]
        for j in range(i, -1, -1):
            if left <= arr[j][0]:
                left = min(left, arr[j][0] - arr[j][1])
                sol_left[i] = min(sol_left[i], j)
        for j in range(i + 1, n):
            if right >= arr[j][0]:
                right = max(right, arr[j][0] + arr[j][1])
                sol_right[i] = max(sol_right[i], j)
    dp = [INF for i in range(n)]
    dp[0] = 1
    for i in range(n):
        if sol_left[i] - 1 < 0:
            dp[i] = min(dp[i], 1)
        else:
            dp[i] = min(dp[i], dp[sol_left[i] - 1] + 1)
        for j in range(i):
            if sol_right[j] >= i:
                if j == 0:
                    dp[i] = min(dp[i], 1)
                else:
                    dp[i] = min(dp[i], dp[j - 1] + 1)
    return dp[n - 1]
    
    
    
n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]
arr.sort()
print(solution(n, arr))
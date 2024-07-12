import sys
input = sys.stdin.readline

N, M = map(int, input().split());
visited = [0] * (N + 1)
global arr
arr = []

def dfs(i):
    arr.append(i)
    visited[i] = 1
    if len(arr) == M:
        print(' '.join(map(str, arr)))
    else:
        for j in range(1, N + 1):
            if visited[j] == 0:
                dfs(j)
    visited[i] = 0
    arr.pop()

for i in range(1, N + 1):
    dfs(i)

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)
n = int(input())

load = [[] for i in range(n+1)]
answer = 0
for i in range(n-1):
    a, b, c = map(int, input().split())
    load[a].append((b, c))
    load[b].append((a, c))

leaf = [-1 for _ in range(n+1)]
result = [-1 for _ in range(n+1)]
def dfs(x, array):
    for i in load[x]:
        if array[i[0]] == -1:
            array[i[0]] = array[x] + i[1]
            dfs(i[0],array)
leaf[1] = 0
dfs(1, leaf)
idx = 0
for i in range(n+1):
    if leaf[i] == max(leaf):
        idx = i
result[idx] = 0
dfs(idx, result)
print(max(result))
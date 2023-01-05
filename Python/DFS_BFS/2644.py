n = int(input())
t1, t2 = map(int, input().split())
G = [[0] * (n + 1) for _ in range(n + 1)]
t = int(input())
for _ in range(t):
    n1, n2 = map(int, input().split())
    G[n1][n2] = G[n2][n1] = 1
result = []
def dfs(V, visited = [], ans = 0):
    visited.append(V)
    ans += 1
    if V == t2:
        result.append(ans)
    
    for i in range(n + 1):
        if G[V][i] == 1 and (i not in visited):
            dfs(i, visited, ans)
dfs(t1)
if len(result) == 0:
    print(-1)
else:
    print(result[0]-1)

n = int(input())
t = int(input())
G = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(t):
    n1, n2 = map(int, input().split())
    G[n1][n2] = G[n2][n1] = 1
answer = 0

def dfs(V, visited = []):
    global answer
    visited.append(V)
    answer += 1
    
    for i in range(n + 1):
        if G[V][i] == 1 and (i not in visited):
            dfs(i, visited)
dfs(1)
print(answer - 1)
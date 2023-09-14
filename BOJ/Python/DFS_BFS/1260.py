from collections import deque

N, M, V = map(int, input().split())
G = [[0] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    n1, n2 = map(int, input().split())
    G[n1][n2] = G[n2][n1] = 1

def bfs(V):
    discovered = [V]
    queue = deque()
    queue.append(V)
    
    while queue:
        x = queue.popleft()
        print(x, end = ' ')
        
        for i in range(len(G[V])):
            if G[x][i] == 1 and (i not in discovered):
                discovered.append(i)
                queue.append(i)
            


def dfs(start, discovered = []):
    discovered.append(start)
    print(start, end = ' ')
    
    for i in range(len(G[start])):
        if G[start][i] == 1 and (i not in discovered):
            dfs(i, discovered)

dfs(V)
print()
bfs(V)
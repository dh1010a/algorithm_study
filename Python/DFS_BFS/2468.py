from collections import deque
N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
visited = [[0 for _ in range(N)] for _ in range(N)]
cnt = 1

def is_possible(x, y, t):
    return 0 <= x < N and 0 <= y < N and graph[x][y] > t and visited[x][y] == 0

def find_area(x, y, t):
    queue = deque()
    queue.append((x, y))
    global cnt
    while queue:
        x, y = queue.popleft()
        visited[x][y] = 1
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_possible(nx, ny, t):
                queue.append((nx, ny))
                visited[nx][ny] = cnt
    cnt += 1
result = []
max_num = 0
for i in range(N):
    max_num = max(max_num, max(graph[i]))
for t in range(max_num):
    visited = [[0 for _ in range(N)] for _ in range(N)]
    cnt = 1
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0 and graph[i][j] > t:
                find_area(i, j, t)
    result.append(cnt)
print(max(result) - 1)
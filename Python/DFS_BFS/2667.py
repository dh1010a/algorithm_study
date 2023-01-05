from collections import deque
N = int(input())
graph = [list(map(int, input())) for _ in range(N)]
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
visited = [[0 for _ in range(N)] for _ in range(N)]
cnt = 1

def is_possible(x, y):
    return 0 <= x < N and 0 <= y < N and graph[x][y] != 0 and visited[x][y] == 0

def find_town(x, y):
    now_d = 0
    queue = deque()
    queue.append((x, y))
    global cnt
    while queue:
        x, y = queue.popleft()
        visited[x][y] = cnt
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_possible(nx, ny):
                queue.append((nx, ny))
                visited[nx][ny] = cnt
    cnt += 1
                
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0 and graph[i][j] != 0:
            find_town(i, j)

print(cnt-1)
result = []
for i in range(1, cnt):
    tmp = 0
    for j in range(N):
        tmp += visited[j].count(i)
    result.append(tmp)
result.sort()
for i in range(len(result)):
    print(result[i])
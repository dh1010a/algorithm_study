from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
visited = [[0 for _ in range(m)] for _ in range(n)]
cnt = 1

def is_possible(x, y):
    return 0 <= x < n and 0 <= y < m and visited[x][y] == 0

def solution(x, y):
    queue = deque()
    global cnt
    queue.append((x, y))
    visited[x][y] = cnt
    melt = []
    while queue:
        x, y = queue.popleft()
        visited[x][y] = cnt
        tmp = 0
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_possible(nx, ny) and graph[nx][ny] == 0 and [nx, ny] not in melt:
               tmp += 1
            elif is_possible(nx, ny) and graph[nx][ny] != 0:
                queue.append([nx, ny])
                visited[nx][ny] = cnt
        graph[x][y] -= tmp
        if graph[x][y] < 0:
            graph[x][y] = 0
        if graph[x][y] == 0 and [x, y] not in melt:
            melt.append([x, y])
    cnt += 1

answer = 0   
while True:
    cnt = 1
    visited = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(n-1):
        for j in range(m-1):
            if graph[i][j] != 0 and visited[i][j] == 0:
                solution(i, j)
    answer += 1
    if cnt > 2:
        break
    cnt_tmp = 0
    if cnt == 1:
        answer = 1
        break

print(answer-1)
        
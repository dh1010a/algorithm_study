import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())
graph = [list(map(int, input().split())) for i in range(n)]
visited = [[0 for _ in range(m)] for _ in range(n)]
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]

def is_possible(x, y):
    return 0 <= x < n and 0 <= y < m and graph[x][y] == 0 
cnt = 1
visited[r][c] = 1
while True:
    find = 0
    for i in range(4):
        d = (d + 3)%4
        nx, ny = r + dx[d], c + dy[d]
        if is_possible(nx, ny) and visited[nx][ny] == 0:
            visited[nx][ny] = 1
            r, c = nx, ny
            cnt += 1
            find += 1
            break
    if find == 0:
        if graph[r-dx[d]][c-dy[d]] == 1:
            print(cnt)
            break
        else:
            r, c = r - dx[d], c - dy[d]
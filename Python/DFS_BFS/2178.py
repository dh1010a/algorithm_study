from collections import deque
N, M = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

def is_possible(x, y):
    return x >= 0 and y >= 0 and x < N and y < M and maze[x][y] == 1

def find_path():
    x, y, cnt, now_d = 0, 0, 1, 0
    queue = deque()
    queue.append((x, y))
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_possible(nx, ny):
                queue.append((nx, ny))
                maze[nx][ny] = maze[x][y] + 1
    return maze[N-1][M-1]

print(find_path())
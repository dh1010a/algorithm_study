from collections import deque

def is_range(x, y):
    return 0 <= x < 5 and 0 <= y < 5

def solution(maps):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    queue = deque()
    queue.append((0, 0))
    while queue:
        x, y = queue.popleft()
        if x == len(maps)-1 and y == len(maps[0]) - 1:
            return maps[x][y]
        maps[x][y] += 1
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_range(nx, ny) and maps[nx][ny] == 1:
                queue.append((nx, ny))
                
    return -1
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
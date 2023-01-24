import sys
n, m = map(int, sys.stdin.readline().split())
arr = [list (map(int, sys.stdin.readline().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
max_val = max(map(max, arr))
res = 0
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def is_possible(x, y):
    return 0 <= x < n and 0 <= y < m and visited[x][y] == 0

def dfs(x, y, cnt, tmp):
    global res
    if tmp + max_val*(4-cnt) <= res:
        return
    if cnt == 3:
        res = max(res, tmp)
        return
    else:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if is_possible(nx,ny):
                if cnt == 1:
                    visited[nx][ny] = 1
                    dfs(x, y, cnt + 1, tmp + arr[nx][ny])
                    visited[nx][ny] = 0
                
                visited[nx][ny] = 1
                dfs(nx, ny, cnt + 1, tmp + arr[nx][ny])
                visited[nx][ny] = 0
            
    
    
for i in range(n):
    for j in range(m):
        visited[i][j] = 1
        dfs(i, j, 0, arr[i][j])
        visited[i][j] = 0

print(res)
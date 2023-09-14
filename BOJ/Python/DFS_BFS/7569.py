from collections import deque
M, N, H = map(int, input().split())
box = []
for i in range(H):
    tmp = []
    for j in range(N):
        tmp.append(list(map(int, input().split())))
    box.append(tmp)

dx = [1, 0, -1, 0, 0, 0]
dy = [0, -1, 0, 1, 0 ,0]
dz = [0, 0, 0, 0, -1, 1]

def is_possible(i, j, k):
    return 0 <= i < H and 0 <= j < N and 0 <= k < M and box[i][j][k] == 0
queue = deque()
def bfs():
    while queue:
        x, y, z = queue.popleft()
        for i in range(6):
            nx, ny, nz = x + dz[i], y + dy[i], z + dx[i]
            if (is_possible(nx, ny, nz)):
                if box[nx][ny][nz] == 0:
                    box[nx][ny][nz] = box[x][y][z] + 1
                    queue.append((nx, ny, nz))
                
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 1:
                queue.append((i, j, k))

bfs()
flag = 0
result = -2
for i in range(H):
    for j in range(N):
        for k in range(M):
            if box[i][j][k] == 0:
                flag = 1
            result = max(result,box[i][j][k])
     
if flag == 1:
    print(-1)
elif result == -1:
    print(0)
else:
    print(result-1)
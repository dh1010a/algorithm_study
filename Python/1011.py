n, m = map(int, input().split())
arr = [[0] * m for _ in range(n)]

dir_x = [0, 1, 0, -1]
dir_y = [1, 0, -1, 0]
x, y = 0, 0
now_dir = 0

def is_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n
    
arr[x][y] = 1
for i in range(2, n * m + 1):
    dx, dy = x + dir_x[now_dir], y + dir_y[now_dir]

    if not is_range(dx, dy) or arr[dx][dy] != 0:
        now_dir = (now_dir + 1) % 4

    x, y = x + dir_x[now_dir], y + dir_y[now_dir]
    arr[x][y] = i

for i in range(n):
    for j in range(m):
        print(arr[i][j], end = ' ')
    print()

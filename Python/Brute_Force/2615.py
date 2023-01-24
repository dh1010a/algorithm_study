from collections import deque 
arr = [list(map(int, input().split())) for _ in range(19)]
dx = [0, 1, 1, -1]
dy = [1, 1, 0, 1]

def is_range(x, y):
    return 0 <= x < 19 and 0 <= y < 19

for i in range(19):
    for j in range(19):
        queue = deque()
        if arr[i][j] != 0:
            for k in range(4):
                queue.append(arr[i][j])
                x, y = i, j
                while is_range(x+dx[k], y+dy[k]) and arr[x+dx[k]][y+dy[k]] == arr[i][j]:
                    queue.append(arr[x+dx[k]][y+dy[k]])
                    x += dx[k]
                    y += dy[k]
                if len(queue) == 5:
                    if not is_range(x-dx[k], y-dy[k]) and arr[i-dx[k]][j-dy[k]] == arr[i][j]:
                        break
                    else:
                        print(arr[i][j])
                        print(i+1, j+1)
                        exit()
                queue.clear()
print(0)
from math import sqrt
n, m = map(int, input().split())

arr = [list(map(int, input())) for _ in range(n)]
result = -1
def is_sqrt(x):
    if int(sqrt(int(x))) ** 2 == int(x):
        return True
    else:
        return False

for i in range(n):
    for j in range(m): #각 행과 열을 선택하고 시작
        for diff_x in range(-n, n):
            for diff_y in range(-m, m):
                tmp = ''
                x, y = i, j
                if diff_x == 0 and diff_y == 0:
                    continue
                while 0 <= x < n and 0 <= y < m:
                    tmp += str(arr[x][y])
                    if is_sqrt(tmp):
                        result = max(result, int(tmp))
                    x += diff_x
                    y += diff_y

print(result)
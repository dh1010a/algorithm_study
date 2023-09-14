import sys
input = sys.stdin.readline
n = int(input())

arr = [list(map(int, input().split())) for i in range(n)]
result = [0, 0, 0]
def recursive(x, y, n):
    check = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j] != check:
                for k in range(3):
                    recursive(x + k * (n//3), y, n//3)
                    recursive(x + k * (n//3), y + n//3, n//3)
                    recursive(x + k * (n//3), y+(n//3 * 2), n//3)
                return
    result[check + 1] += 1
    
    
recursive(0, 0, n)
for i in result:
    print(i)
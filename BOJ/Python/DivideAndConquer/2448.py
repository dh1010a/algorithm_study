import sys
input = sys.stdin.readline
n = int(input())
arr = [[" "]* (2*n-1) for _ in range(n)]

def recursive(x, y, n):
    if n == 3:
        arr[x][y] = "*"
        arr[x+1][y-1] = arr[x+1][y+1] = "*"
        for i in range(5):
            arr[x+2][y-2 + i] = "*"
        return
    next_n = n//2
    recursive(x, y, next_n)
    recursive(x + next_n, y - (next_n), next_n)
    recursive(x + next_n, y + (next_n), next_n)

recursive(0, (2*n-1)//2, n)

for i in range(n):
    print("".join(arr[i]))
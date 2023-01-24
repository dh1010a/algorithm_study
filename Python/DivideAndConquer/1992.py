import sys
n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]

def recursion(x, y, n):
    check = arr[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if arr[i][j] != check:
                print("(", end = '')
                recursion(x, y, n//2)
                recursion(x, y+n//2, n//2)
                recursion(x+n//2, y, n//2)
                recursion(x+n//2, y+n//2, n//2)
                print(")", end = '')
                return
    
    if check == 0:
        print("0", end = '')
        return
    else:
        print("1", end = '')
        return
        
recursion(0, 0, n)
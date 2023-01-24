n = int(input())
arr = [[" "]*n for i in range(n)]

def is_possible(x, y):
    return 0 <= x < n and 0 <= y < n
    

def recursion(x, y, n):
    if n <= 3:
        for i in range(3):
            for j in range(3):
                if i==1 and j==1:
                    continue
                arr[x+i][y+j] = "*"
        return
    else:
        for i in range(x, x+n, n//3):
            for j in range(y, y+n, n//3):
                if i == x+n//3 and j == y+n//3:
                    continue
                else:
                    if is_possible(x, y):
                        recursion(i, j, n//3)
    
recursion(0, 0, n)
for i in range(n):
    print("".join(arr[i]))
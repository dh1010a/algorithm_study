T = int(input())
tmp = [0 for _ in range(11)]

def find(n):
    
    tmp[1], tmp[2], tmp[3] = 1, 2, 4
    if n <= 3 or tmp[n] != 0:
        return tmp[n]
    tmp[n] = find(n-1) + find(n-2) + find(n-3)
    return tmp[n]

for _ in range(T):
    n = int(input())
    print(find(n))
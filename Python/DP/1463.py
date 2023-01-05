x = int(input())
tmp = [0 for _ in range(x + 1)]

def make_one(n):
    if n == 1 or tmp[n] != 0:
        return tmp[n]
    elif n % 3 == 0 and n % 2 == 0:
        tmp[n] = min(make_one(n//3), make_one(n//2)) + 1 
    elif n % 3 == 0:
        tmp[n] = min(make_one(n//3), make_one(n-1)) + 1
    elif n % 2 == 0:
        tmp[n] = min(make_one(n//2), make_one(n-1)) + 1
    else :
        tmp[n] = make_one(n-1) + 1
    return tmp[n]

print(make_one(x))
    
x = int(input())
tmp = [0 for _ in range(x + 1)]

def make_one(x):
    if x == 1:
        return 0
    for i in range(2, x+1):
        tmp[i] = tmp[i-1] + 1
        if i % 3 == 0:
            tmp[i] = min(tmp[i//3] + 1, tmp[i])
        if i % 2 == 0:
            tmp[i] = min(tmp[i//2] + 1, tmp[i])
    return tmp[x]

print(make_one(x))
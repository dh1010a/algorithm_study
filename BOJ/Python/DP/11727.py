n = int(input())
tmp = [1 for _ in range(n+1)]

def tile(n):
    if n == 1:
        return tmp[1]
    for i in range(2, n + 1):
        tmp[i] = 2 * tmp[i-2] + tmp[i-1]
    return tmp[n] % 10007

print(tile(n))
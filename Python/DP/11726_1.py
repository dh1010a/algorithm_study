n = int(input())
tmp = [1 for _ in range(n+1)]
if n>=2:
      tmp[2]=2

def tile(n):
    if n <= 2 or tmp[n] > 1:
        return tmp[n]
    a = tmp[n-2] if tmp[n-2] > 1 else tile(n-2)
    b = tmp[n-1] if tmp[n-1] > 1 else tile(n-1)
    tmp[n] = a + b
    return tmp[n]

print(tile(n) % 10007)
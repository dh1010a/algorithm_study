n, m = map(int, input().split())

def is_prime(x):
    if x <= 1:
        return 0
    i = 2
    while i*i <= x:
        if x % i == 0:
            return 0
        i+=1
    return 1

for i in range(n, m+1):
    if is_prime(i):
        print(i)
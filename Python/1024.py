N, L = map(int, input().split())

for i in range(L, 101):
    x = N - (i + 1) * i / 2
    if x % i == 0:
        x = int(x / i)
        
        if x + 1 >= 0:
            for i in range(1, i + 1):
                print(x + i, end=' ')
            print()
            break
else:
    print(-1)
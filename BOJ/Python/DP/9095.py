T = int(input())

for _ in range(T):
    n = int(input())
    tmp = [0 for _ in range(11)]
    tmp[1], tmp[2], tmp[3] = 1, 2, 4
    if n <= 3:
        print(tmp[n])
    else:
        for i in range(4, n + 1):
            tmp[i] = tmp[i-1] + tmp[i-2] + tmp[i-3]
        print(tmp[n])
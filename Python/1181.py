N = int(input())
arr = [str(input()) for _ in range(N)]
arr = sorted(list(set(arr)), key=lambda x: (len(x), x))
for i in arr:
    print(i)
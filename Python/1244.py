N = int(input())
switches = [-1] + list(map(int, input().split()))
Std_N = int(input())

def convert(x):
    if switches[x] == 0:
        switches[x] = 1
    else:
        switches[x] = 0
    return

def change(s, x):
    if s == 1:
        for i in range(x, N+1, x):
            convert(i)
    else:
        convert(x)
        for k in range(N//2):
            if x + k > N or x - k < 1 : break
            if switches[x + k] == switches[x - k]:
                convert(x + k)
                convert(x - k)
            else:
                break

for _ in range(Std_N):
    s, x = map(int, input().split())
    change(s, x)

for i in range(1, N+1):
    print(switches[i], end = " ")
    if i % 20 == 0 :
        print()
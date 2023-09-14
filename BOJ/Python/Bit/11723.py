import sys
input = sys.stdin.readline

n  = int(input())
s = set()

for _ in range(n):
    a = input().strip().split()
    if len(a) == 1:
        if a[0] == "all":
            s = set([i for i in range(1, 21)])
        else:
            s = set()
    else:
        x = int(a[1])
        if a[0] == "add":
            s.add(x)
        elif a[0] == "remove":
            s.discard(x)
        elif a[0] == "check":
            print(1 if x in s else 0)
        elif a[0] == "toggle":
            if x in s:
                s.discard(x)
            else:
                s.add(x)
        
import sys
input = sys.stdin.readline
n = int(input())


def recursive(n, x, y):
    if n == 1:
        print(x, y)
        return
    recursive(n-1, x, 6-x-y) #1단계
    print(x, y) #2단계
    recursive(n-1, 6-x-y, y) #3단계
    
print(2**n-1)
recursive(n, 1, 3)
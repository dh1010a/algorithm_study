import sys
input = sys.stdin.readline

a, b, c = map(int, input().split())

result = bin(a^b)
if c % 2 == 0:
    result = bin(int(result, 2)^b)
print(int(result, 2))
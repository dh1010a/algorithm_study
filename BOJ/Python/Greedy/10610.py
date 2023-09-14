import sys
from itertools import permutations

input = sys.stdin.readline

n = list(map(str, input().rstrip()))

if '0' not in n:
    print(-1)
    sys.exit()
answer = -1
n.sort(reverse=True)
total = 0
for i in n:
    total += int(i)
if total % 3 == 0:
    answer = int("".join(n))
print(answer)
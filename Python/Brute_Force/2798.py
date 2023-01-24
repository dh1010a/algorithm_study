import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
max_num = 0
result_arr = list(combinations(arr, 3))
for i in result_arr:
    if sum(i) <= m:
        max_num = max(max_num, sum(i))
print(max_num)
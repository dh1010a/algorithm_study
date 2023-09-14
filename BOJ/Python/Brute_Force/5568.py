import sys
from itertools import permutations
n = int(sys.stdin.readline())
k = int(sys.stdin.readline())
arr = []
for _ in range(n):
    arr.append(sys.stdin.readline().strip())
per_arr = list(permutations(arr, k))
result_arr = []
for i in per_arr:
    tmp = ''
    for j in range(k):
        tmp += i[j]
    if tmp not in result_arr:
        result_arr.append(tmp)
print(len(result_arr))


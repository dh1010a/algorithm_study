import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = sys.maxsize
tmp = [i for i in range(n)]
arr2 = list(permutations(tmp, n))
    
for i in arr2:
    cnt = 0
    for j in range(len(i)-1):
        cnt += arr[i[j]][i[j+1]]
    cnt += arr[i[-1]][i[0]]
    answer = min(answer, cnt)
print(answer)
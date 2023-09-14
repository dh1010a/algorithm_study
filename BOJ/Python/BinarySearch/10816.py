import sys
input = sys.stdin.readline
from collections import Counter
n = int(input())
arr = list(map(int, input().split()))
m = int(input())
card = list(map(int, input().split()))
arr.sort()
count = Counter(arr)
for i in range(m):
    if card[i] in count:
        print(count[card[i]], end=' ')
    else:
        print(0, end=' ')
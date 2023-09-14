import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
start, end = 0, max(arr)
max_h = 0
while start <= end:
    mid = (start + end)//2
    tmp = 0
    for i in arr:
        if i - mid > 0:
            tmp += i - mid
    if tmp < m:
        end = mid - 1
    else:
        max_h = mid
        start = mid + 1
print(max_h)
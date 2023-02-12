import sys

k, n = map(int, input().split())
lines = [int(sys.stdin.readline()) for _ in range(k)]
left, right = 1, max(lines) + 1
max_len = 0
while(left <= right):
    mid = (left + right) // 2
    answer = sum(i//mid for i in lines)
    if answer >= n:
        left = mid + 1
        max_len = mid
    elif answer < n:
        right = mid - 1
        

print(max_len)
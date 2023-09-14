import sys
input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
cnt = 0
for i in range(n):
    cnt += sum(arr[i])
print(cnt)

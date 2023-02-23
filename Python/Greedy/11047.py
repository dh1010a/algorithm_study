import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = [int(input()) for _ in range(n)]
answer = 0
arr.sort(reverse=True)
for i in arr:
    answer += k // i
    k = k % i
print(answer)
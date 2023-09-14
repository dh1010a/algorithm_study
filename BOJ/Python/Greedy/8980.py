import sys
input = sys.stdin.readline

n, limit = map(int, input().split())
m = int(input())
arr = [list(map(int, input().split())) for i in range(m)]
trucks = [limit for i in range(n+1)]
arr.sort(key=lambda x: x[1])
result = 0
for i in arr:
    min_box = limit
    for j in range(i[0], i[1]):
        min_box = min(min_box, trucks[j])
    min_box = min(min_box, i[2])
    for j in range(i[0], i[1]):
        trucks[j] -= min_box
    result += min_box
print(result)
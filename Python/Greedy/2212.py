import sys
input = sys.stdin.readline
n = int(input())
k = int(input())
sensor = list(map(int, input().split()))

sensor.sort()
dist = []

if k >= n:
    print(0)
    sys.exit()
for i in range(n-1):
    dist.append(sensor[i+1] - sensor[i])
dist.sort(reverse=True)
for _ in range(k-1):
    dist.pop(0)
print(sum(dist))
import sys
from collections import deque
input = sys.stdin.readline
t = int(input())

def solution():
    queue = deque()
    queue.append([home[0], home[1]])
    while queue:
        x, y = queue.popleft()
        if abs(x - festival[0]) + abs(y - festival[1]) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                now_x, now_y = cu[i]
                if abs(x - now_x) + abs(y - now_y) <= 1000:
                    queue.append([now_x, now_y])
                    visited[i] = 1
    print("sad")
    return
        
for _ in range(t):
    n = int(input())
    home = [int(x) for x in input().split()]
    cu = []
    for _ in range(n):
        cu_x, cu_y = map(int, input().split())
        cu.append([cu_x, cu_y])
    festival = [int(x) for x in input().split()]
    visited = [0 for _ in range(n + 1)]
    solution()
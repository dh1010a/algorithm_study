import sys
from collections import deque
from queue import PriorityQueue
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for i in range(n)]
arr.sort(key=lambda x: x[0])
queue = deque(arr)
room = PriorityQueue()
max_len = 0
x = queue.popleft()
room.put([x[1],x[0]])
while queue:
    x = queue.popleft()
    tmp = room.get()
    while room.qsize() > 0 and x[0] >= tmp[0]:
        tmp = room.get()
    if x[0] < tmp[0]:
        room.put([x[1],x[0]])
        room.put(tmp)
    elif x[0] == tmp[0]:
        room.put(x)
    max_len = max(max_len, room.qsize())
print(max_len)
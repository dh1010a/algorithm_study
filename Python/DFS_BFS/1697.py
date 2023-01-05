from collections import deque
n, k = map(int, input().split())
MAX_SIZE = 100001
queue = deque()
visited = [0] * MAX_SIZE
def find(n):
    queue.append(n)
    while queue:
        x = queue.popleft()
        if x == k:
            return visited[k]
        tmp = [x-1, x+1, 2*x]
        for i in tmp:
            if 0 <= i <= 100000 and not visited[i]:
                visited[i] = visited[x] + 1
                queue.append(i)
print(find(n))

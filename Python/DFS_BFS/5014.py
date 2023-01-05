from collections import deque
f, s, g, u, d = map(int, input().split())
visited = [0] * (f+1)
queue = deque()
def is_possible(x):
    return 0 < x <= f

def find(s):
    queue.append(s)
    visited[s] = 1
    while queue:
        x = queue.popleft()
        if x == g:
            return visited[g]
        tmp = [x + u, x - d]
        for i in tmp:
            if is_possible(i) and not visited[i]:
                visited[i] = visited[x] + 1
                queue.append(i)
rst = find(s)
if visited[g] == 0:
    print("use the stairs")
else:
    print(rst - 1)
import sys
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = sys.maxsize
def dfs(x,next,tmp, visited):
    global answer
    if len(visited) == n:
        if arr[next][x] != 0:
            answer = min(answer, tmp + arr[next][x])
    for i in range(n):
        if arr[next][i] != 0 and i not in visited and tmp < answer:
            visited.append(i)
            dfs(x, i,tmp + arr[next][i],visited)
            visited.pop()
    

for i in range(n):
    dfs(i,i,0,[i])
    
print(answer)
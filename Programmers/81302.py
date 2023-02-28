from collections import deque
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
def is_range(x, y):
    return 0 <= x < 5 and 0 <= y < 5

def solution(places):
    answer = []
    sol =[]
    for room in places:
        queue = deque()
        for i in range(5):
            for j in range(5):
                if room[i][j] == 'P':
                    queue.append((i,j))
        find = 1
        while queue and find == 1:
            x, y = queue.popleft()
            for i in range(4):
                nx, ny = x + dx[i], y + dy[i]
                if is_range(nx, ny) and room[nx][ny] != 'X':
                    if room[nx][ny] == 'P': #바로 옆에 앉은 경우
                        find = 0
                        break
                    for j in range(4): ## 대각선, 두칸 옆 검사
                        nnx,nny = nx + dx[j], ny + dy[j]
                        if is_range(nnx, nny) and not (x == nnx and y == nny):
                            if room[nnx][nny] == 'P':
                                sol.append((nx, ny))
                                find = 0
                                break
                if find == 0:
                    break
        answer.append(find)
        queue.clear()
                    
                        
                
    return answer
from collections import deque
def solution(routes):
    queue = deque()
    routes.sort(key=lambda x: x[1])
    for i in routes:
        queue.append(i)
    answer = 0
    while queue:
        tmp = queue.popleft()
        while queue and queue[0][0] <= tmp[1] <= queue[0][1]:
            queue.popleft()
        answer += 1
    return answer

#프로그래머스 레벨3 단속카메라
#그리디
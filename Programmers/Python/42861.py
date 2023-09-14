from collections import deque
def solution(n, costs):
    answer = 0
    costs.sort(key=lambda x : x[2])
    queue = []
    cost = 0
    for i in costs:
        queue.append(i)
    visited = deque()
    visited.append(0)
    now_d = 0
    while queue and len(visited) < n:
        if queue[now_d][0] in visited and queue[now_d][1] in visited:
            queue.pop(now_d)
            now_d = 0
        elif queue[now_d][0] in visited and queue[now_d][1] not in visited:
            cost += queue[now_d][2]
            visited.append(queue[now_d][1])
            queue.pop(now_d)
            now_d = 0
        elif queue[now_d][1] in visited and queue[now_d][0] not in visited:
            cost += queue[now_d][2]
            visited.append(queue[now_d][0])
            queue.pop(now_d)
            now_d = 0
        else:
            now_d += 1
    answer = cost
    return answer

#프로그래머스 레벨3 섬 연결하기
#그리디
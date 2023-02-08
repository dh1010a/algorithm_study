from collections import deque

def solution(people, limit):
    answer = 0
    people.sort(reverse = True)
    queue = deque(people)
    tmp = 0
    while queue:
        tmp = limit - queue.popleft()
        while queue and queue[-1] <= tmp:
            tmp -= queue.pop()
        answer += 1
    return answer

#프로그래머스 레벨2 구명보트
#그리디
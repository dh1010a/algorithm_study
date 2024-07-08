from collections import deque
def solution(queue1, queue2):
    answer = 0
    dq1 = deque()
    dq2 = deque()
    sum1 = 0
    sum2 = 0
    for i in range(len(queue1)):
        dq1.appendleft(queue1[i])
        dq2.appendleft(queue2[i])
        sum1 += queue1[i]
        sum2 += queue2[i]
        
    target = (sum1 + sum2) / 2
    if (sum1 + sum2) % 2 != 0:
        return -1
    while True:
        if answer > len(queue1) * 3:
            return -1
        if sum1 == target:
            break
        elif sum1 > target:
            sum1 -= dq1[-1]
            dq2.appendleft(dq1.pop())
        else :
            sum1 += dq2[-1]
            dq1.appendleft(dq2.pop())
        answer += 1
            
    return answer
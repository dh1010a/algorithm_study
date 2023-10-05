# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")
from collections import deque

def solution(A, B):
    stack = []
    answer = 0
    for i in range(len(A)):
        if B[i] == 1:
            stack.append(A[i])
        else:
            while stack:
                tmp = stack.pop()
                if tmp > A[i]:
                    stack.append(tmp)
                    break
        if not stack:
            answer += 1

    answer += len(stack)
        
    return answer


def solution(A, B):
    down_stacks = []
    pass_cnt = 0
    for a, b in zip(A, B):
        if b == 1:
            down_stacks.append(a)
        else:
            while down_stacks:
                if down_stacks[-1] < a:
                    down_stacks.pop()
                else:
                    break
            else:
                pass_cnt+=1
    return pass_cnt + len(down_stacks)
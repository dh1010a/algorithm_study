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

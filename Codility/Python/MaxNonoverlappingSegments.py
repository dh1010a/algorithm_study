def solution(A, B):
    if len(A) == 0:
        return 0
    if len(A) == 1:
        return 1
    answer = 1
    tmp = A[-1]
    for i in range(len(B)-2, -1, -1):
        if B[i] < tmp:
            tmp = A[i]
            answer += 1
    return answer

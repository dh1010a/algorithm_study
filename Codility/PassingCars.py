def solution(A):
    answer = 0
    a_len = sum(A)
    for i in range(len(A)):
        if A[i] == 0:
            answer += a_len
            if answer > 1000000000:
                return -1
        else:
            a_len -= 1
    return answer
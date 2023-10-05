def solution(A):
    max_e = -1000000
    max_s = 0
    if len(A) == 1:
        return A[0]
    for i in A:
        max_e = max(max_e, max_s + i)
        max_s = max(0 , max_s + i)
    return max_e
def solution(A):
    if len(A) == 0:
        return -1
    B = sorted(A)
    tmp = B[len(A)//2]
    if B.count(tmp) > len(A)/2:
        return A.index(tmp)
    else:
        return -1
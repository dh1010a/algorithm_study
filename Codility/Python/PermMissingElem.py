def solution(A):
    N = len(A)
    return ((N+1)*(N+2))//2 - sum(A)
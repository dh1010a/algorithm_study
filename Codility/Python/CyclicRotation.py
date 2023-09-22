def solution(A, K):
    if len(A) == 0:
        return A
    return A[-K%len(A):] + A[:-K%len(A)]
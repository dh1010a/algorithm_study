def solution(A):
    left = A[0]
    right = sum(A[1:])
    mn = abs(left-right)
    for i in range(1, len(A)-1):
        left+=A[i]
        right-=A[i]
        mn = min(mn, abs( left - right ))
    return mn
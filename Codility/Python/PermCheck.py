def solution(A):
    s = set(A)
    max_num = max(A)
    if len(s) != max_num or len(A) != max_num:
        return 0
    return 1
def solution(N):
    i = 1
    tmp = set()
    while i * i <= N:
        if N % i == 0:
            tmp.add(i)
            tmp.add(N//i)
        i += 1
    return len(tmp)
# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N):
    tmp = []
    i = 0
    while N > 0:
        if N % 2 == 1:
            tmp += [i]
        N = N // 2
        i+=1
    answer = max([0] + [i-j-1 for i, j in zip(tmp[1:], tmp[:-1])])
    return answer

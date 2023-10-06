def solution(N):
    i = 1
    answer = 2 * (1 + N)
    while i*i <= N:
        if N % i == 0:
            answer = min(answer, 2 * (i+(N//i)))
        i += 1
    return answer

def solution(A):
    N = len(A)
    answer = [0] * N
    cnt_arr = [0] * (N * 2 + 1)
    saved = [-1] * (N * 2 + 1)
    for i in A:
        cnt_arr[i] += 1
    for i in range(N):
        current = A[i]
        if saved[current] != -1:
            answer[i] = saved[current]
        else:
            tmp = 0
            j = 1
            while j * j <= current:
                if current % j == 0:
                    tmp += cnt_arr[j]
                    if current / j != j:
                        tmp += cnt_arr[current/j]
                j += 1
            answer[i] = N - tmp
            saved[current] = answer[i]
    return answer

def solution(A):
    N = len(A)
    element = [0]*(2*N+1)
    for a in A:
        element[a] += 1
    
    answer = [0]*N
    saved = [-1] * (2*N+1)
    for i in range(N):
        current = A[i]
        if saved[current] != -1:
            answer[i] = saved[current]
        else :
            count = 0
            for j in range(1, int(current**0.5) + 1):
                if current%j == 0:
                    count += element[j]
                    if j != current//j:
                        count += element[current//j]
            answer[i] = N - count
            saved[current] = answer[i]

    return answer
    



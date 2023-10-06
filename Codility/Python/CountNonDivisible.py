def solution(A):
    answer = [0] * len(A)
    cnt_arr = [0] * (len(A) * 2 + 1)
    saved = [-1] * (len(A) * 2 + 1)
    for i in A:
        cnt_arr[i] += 1
    for i in range(len(A)):
        if saved[A[i]] != -1:
            answer[i] = saved[A[i]]
        else:
            tmp = 0
            j = 1
            while j * j <= A[i]:
                if A[i] % j == 0:
                    tmp += cnt_arr[j]
                    if A[i] / j != j:
                        tmp += cnt_arr[A[i]//j]
                j += 1
            answer[i] = len(A) - tmp
            saved[A[i]] = answer[i]
    return answer
    



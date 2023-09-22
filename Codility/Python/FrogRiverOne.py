def solution(X, A):
    arr = set()
    time = 0
    for i in A:
        arr.add(i)
        if len(arr) == X:
            return time
        time+=1
    return -1
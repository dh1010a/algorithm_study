def solution(A):
    tmp = sorted(A)
    res = [ tmp[i] for i in range(0, len(tmp), 2) 
            if i == len(tmp)-1 or tmp[i] != tmp[i+1]]
    return res[0]
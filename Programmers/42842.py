def solution(brown, yellow):
    answer = []
    tmp = []
    i = 1
    while i <= yellow:
        if yellow % i == 0:
            tmp.append(i)
        i += 1
    tmp.sort(reverse=True)
    for i in tmp:
        if (i+2) *2 + (yellow // i) * 2 == brown:
            answer = [yellow // i + 2, i + 2]    
    return answer
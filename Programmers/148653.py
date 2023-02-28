def solution(storey):
    answer = 0
    while storey > 0:
        tmp = storey % 10
        if tmp >= 6:
            answer += (10 - tmp)
            storey += (10 - tmp)
        elif tmp == 5 and (storey // 10) % 10 >= 5:
            answer += (10 - tmp)
            storey += (10 - tmp)
        else :
            answer += tmp
        storey = storey // 10
        
    return answer
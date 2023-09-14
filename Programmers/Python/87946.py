import itertools

def solution(k, dungeons):
    answer = -1
    npr = itertools.permutations(dungeons, 3)
    for i in npr:
        cnt = 0
        h = k
        for j in i:
            if j[0] <= h:
                cnt += 1
                h -= j[1]
            else:
                break
        answer = max(cnt, answer)
    return answer

print(solution(80, [[80,20],[50,40],[30,10]]))
from collections import Counter
def solution(topping):
    dic = Counter(topping)
    a = set()
    answer = 0
    for i in topping:
        dic[i] -= 1
        a.add(i)
        if dic[i] == 0:
            dic.pop(i)
        if len(dic) == len(a):
            answer += 1
    return answer
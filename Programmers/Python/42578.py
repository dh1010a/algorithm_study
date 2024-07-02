def solution(clothes):
    answer = 1
    dict = {}
    for i, j in clothes:
        dict[j] = dict.get(j, 0) + 1;
    for key, value in dict.items():
        answer *= value + 1
    return answer - 1
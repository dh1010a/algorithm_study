def solution(sizes):
    answer = 0
    a, b = 0, 0
    for i in sizes:
        a = max(a, max(i))
        b = max(b, min(i))
    answer = a*b
    print(answer)
    return answer
arr = [[60, 50], [30, 70], [60, 30], [80, 40]]
solution(arr)
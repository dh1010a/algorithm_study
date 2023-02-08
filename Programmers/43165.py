arr = []
ans = 0
def find(arr, x, i, result):
    global ans
    if i == len(arr) - 1:
        if x+arr[i] == result:
            ans += 1
            return
        if x - arr[i] == result:
            ans += 1
            return
        return 0
    find(arr, x + arr[i], i+1, result)
    find(arr, x - arr[i], i+1, result)
    return

def solution(numbers, target):
    arr = numbers
    result = target
    find(arr, numbers[0], 1, target)
    find(arr, -1 * numbers[0], 1, target)
    answer = ans
    return answer


#프로그래머스 레벨2 타겟넘버
#DFS/BFS
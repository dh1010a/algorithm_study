import sys
input = sys.stdin.readline

def solution(n, arr):
    sol_left = [1]*n
    for i in range(1, len(arr)):
        for j in range(i):
            if arr[j][0] + arr[j][1] >= arr[i][0]:
                sol_left[i] = max(sol_left[i], sol_left[j] + 1)
                break
                
    sol_right = [1]*n
    for i in range(len(arr)-2, -1, -1):
        for j in range(n-1, i, -1):
            if arr[j][0] - arr[j][1] <= arr[i][0]:
                sol_right[i] = max(sol_right[i], sol_right[j] + 1)
                break
                
    sol = []
    for i in range(len(sol_left)):
        sol.append(sol_left[i] + sol_right[i] - 1)
    answer = max(sol)
    return answer
    
    
    
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
print(solution(n, arr))
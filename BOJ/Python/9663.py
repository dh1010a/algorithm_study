n = int(input())
arr = [0]*n
solution = 0

def is_possible(r):
    for i in range(0, r):
        if arr[i] == arr[r] or abs(r - i) == abs(arr[r] - arr[i]):
            return 0
    return 1

def recursive(r):
    global solution
    if r == n:
        solution += 1
        return
        
    else:
        for i in range(n):
            arr[r] = i
            if is_possible(r):
                recursive(r+1)
    
    
recursive(0)
print(solution)
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = [int(input()) for _ in range(n)]
start, flag = 1, max(arr)
max_len = 0
while start <= flag:
    now_len = (start + flag) // 2
    tmp = 0
    for i in arr:
        tmp += i//now_len
    if tmp < k:
        flag = now_len - 1
    else:
        start = now_len + 1
        max_len = now_len
        
print(max_len)
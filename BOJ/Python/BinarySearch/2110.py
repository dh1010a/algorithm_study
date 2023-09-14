import sys
input = sys.stdin.readline

n, c = map(int, input().split())
arr = [int(input()) for i in range(n)]
arr.sort()

start, end = 1, arr[-1] - arr[0]
answer = 0
if c == 2:
    print(arr[-1] - arr[0])
else:
    while start <= end:
        mid = (start + end) // 2
        cnt = 1
        last_wifi = arr[0]
        for i in arr:
            if i - last_wifi >= mid:
                cnt += 1
                last_wifi = i
        if cnt >= c:
            answer = mid
            start = mid + 1
        else:
            end = mid - 1
    print(answer)


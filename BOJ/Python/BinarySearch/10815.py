import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
card = list(map(int, input().split()))
arr.sort()
for i in card:
    start, end = 0, n-1
    find = 0
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == i:
            print(1, end = " ")
            find = 1
            break
        elif arr[mid] < i:
            start = mid + 1
        else:
            end = mid - 1
    if find == 0:
        print(0, end = " ")
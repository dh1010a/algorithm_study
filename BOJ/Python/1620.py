import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
name = {}
num = {}
for _ in range(n):
    arr.append(input())
for i in range(m):
    flag = 0
    quest = input().strip()
    for j in range(n):
        if quest == arr[j]:
            print(j + 1)
            flag = 1
            break
    if flag == 0:
        print(arr[int(quest) - 1])
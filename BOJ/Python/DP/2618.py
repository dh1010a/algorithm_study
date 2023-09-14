import sys
input = sys.stdin.readline

n = int(input())
w = int(input())
arr = [list(map(int, input().split())) for i in range(w)]
patrol_1, patrol_2 = [1,1], [n,n]
def solution(A):
    buy = 200000
    profit = 0
    for a in A:
        buy = min(a, buy)
        profit = max(profit, a - buy)
    return profit
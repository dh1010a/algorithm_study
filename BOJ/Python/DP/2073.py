import sys
input = sys.stdin.readline
D, P = map(int, input().split())
dp = [0] * (D + 1)
dp[0] = 1e9 ##무한대의 값을 나타내기 위함
for _ in range(P):
    l, c = map(int, input().split())
    tmp = dp[:]
    for i in range(l, D + 1):
        if tmp[i-l]:
            dp[i] = max(dp[i], min(tmp[i - l],c)) # 사용할 경우, 사용하지 않을 경우 중 최대값을 저장
        
print(dp[D])
    

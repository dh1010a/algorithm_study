n = int(input())


for i in range(n):
    x = int(input())
    if x < 6:
        dp = [0, 1, 1, 1, 2, 2]
        print(dp[x])
    else:
        dp = [0 for i in range(x+1)]
        dp[0:6] = [0, 1, 1, 1, 2, 2]
        j = 6
        while j < x+1:
            dp[j] = dp[j-1] + dp[j-5]
            j += 1
        print(dp[x])
            
    
    
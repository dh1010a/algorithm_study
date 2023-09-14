n = input()
len_n = len(n)
dp = [0 for i in range(len(str(n)) + 1)]

if int(n[0]) == 0:
    print(0)
else:
    n = '0'+ n
    dp[0] = 1
    dp[1] = 1
    for i in range(2, len_n + 1):
        if n[i] >= '1' and n[i] <= '9':
            dp[i] += dp[i-1]
        if n[i-1] + n[i] < '27' and n[i-1] + n[i] >= '10':
            dp[i] += dp[i-2]

    print(dp[len_n] % 1000000)
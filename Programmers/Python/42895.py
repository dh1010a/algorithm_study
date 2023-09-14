def solution(N, number):
    dp = [{}]
    dp.append({N})
    answer = 9
    if N == number:
        return 1
    for i in range(2, 9):
        tmp = set()
        tmp.add(int(str(N) * i))
        for x in range(1, i//2+1):
            for j in dp[i-x]:
                for k in dp[x]:
                    if j-k >= 0:
                        tmp.add(j-k)
                    if k-j >= 0:
                        tmp.add(k-j)
                    tmp.add(j+k)
                    tmp.add(j*k)
                    if k != 0:
                        tmp.add(j//k)
                    if j != 0:
                        tmp.add(k//j)
        tmp.discard(0)
        dp.append(tmp)
        if number in tmp:
            print(i)
            answer = i
            break
    if answer > 8:
        return -1
    else:
        return answer
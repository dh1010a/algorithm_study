T = int(input())

zero = [1,0,1]
one = [0,1,1]
def cal(n):
    length = len(zero)
    if length <= n:
        for i in range(length, n+1):
            zero.append(zero[i-1]+zero[i-2])
            one.append(one[i-1]+one[i-2])
    print("%d %d"%(zero[n], one[n]))
    
for i in range(T):
    n = int(input())
    cal(n)

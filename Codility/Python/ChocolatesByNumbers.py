def solution(N, M):
    return N//gcd(N, M)
def gcd(a, b):
    if a % b == 0:
        return b
    else:
        return gcd(b, a % b)
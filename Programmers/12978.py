import sys
def solution(N, road, K):
    answer = 0
    road.sort()
    INF = sys.maxsize
    graph = [[INF]*(N+1) for _ in range(N+1)]
    visited = [0] * (N+1)
    for i in road:
        graph[i[0]][i[1]] = min(i[2], graph[i[0]][i[1]])
        graph[i[1]][i[0]] = min(i[2], graph[i[1]][i[0]])
    dp = [0]*(N+1)
    for i in range(N+1):
        dp[i] = graph[1][i]
    def get_min():
        m = INF
        idx = 0
        for i in range(1, N+1):
            if dp[i] < m and i not in visited:
                m = dp[i]
                idx = i
        return idx
    def dijkstra(start):
        visited.append(start)
        for i in range(N-1):
            now = get_min()
            visited.append(now)
            for j in range(1, N+1):
                if j not in visited:
                    dp[j] = min(dp[now] + graph[now][j], dp[j])
    dijkstra(1)
    for i in dp:
        if i <= K:
            answer +=1

    return answer + 1
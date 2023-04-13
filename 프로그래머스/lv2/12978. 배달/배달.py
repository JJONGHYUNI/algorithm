from collections import deque
def solution(N, road, K):
    answer = 0
    INF = int(1e9)
    cost = [INF] * (N+1)
    cost[1] = 0
    queue = [1]
    while queue :
        pos = queue.pop(0)
        for a,b,c in road:
            if a==pos or b==pos:
                dist = a
                if a==pos:
                    dist = b
                if c+cost[pos] < cost[dist]:
                    cost[dist] = c+cost[pos]
                    queue.append(dist)
    
    for i in cost :
        if i <= K :
            answer += 1
    return answer
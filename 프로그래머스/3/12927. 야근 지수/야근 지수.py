import heapq
def solution(n, works):
    answer = 0
    t = 0
    q = []
    for work in works:
        heapq.heappush(q, -work)
    while t < n:
        t += 1
        tmp = -heapq.heappop(q)
        if tmp == 0:
            return 0
        tmp -= 1
        heapq.heappush(q, -tmp)
    for tmp in q:
        answer += tmp**2
    return answer
import heapq

def solution(operations):
    answer = []
    q = []
    q2 = []
    for oper in operations:
        a,b = oper.split()
        b = int(b)
        
        if a == 'I':
            heapq.heappush(q, b)
            heapq.heappush(q2, -b)
            continue
        
        if q:
            if b == 1:
                tmp = heapq.heappop(q2)
                q.remove(-tmp)
                continue
            tmp = heapq.heappop(q)
            q2.remove(-tmp)
            
    if not q:
        return [0, 0]
    return [-heapq.heappop(q2), heapq.heappop(q)]
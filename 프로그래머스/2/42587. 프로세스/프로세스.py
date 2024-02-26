from collections import deque

def solution(priorities, location):
    answer = 0
    pri = [(a,b) for a,b in enumerate(priorities)]
    q = deque(pri)
    
    while q:
        cur = q.popleft()
        control = 0
        for i in q:
            if cur[1] < i[1] :
                q.append(cur)
                control = 1
                break
        if control:
            continue
        
        answer += 1
        
        if cur[0] == location:
            return answer
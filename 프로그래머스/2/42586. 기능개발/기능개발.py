from collections import deque

def solution(progresses, speeds):
    answer = []
    p = deque(progresses)
    s = deque(speeds)
    
    day = 1
    cnt = 0
    while p:
        if cnt and p[0] + day * s[0] < 100:
            answer.append(cnt)
            cnt = 0
        
        while p[0] + day * s[0] < 100:
            day += 1
            
        cnt += 1
        p.popleft()
        s.popleft()
    
    if cnt:
        answer.append(cnt)
        
    return answer
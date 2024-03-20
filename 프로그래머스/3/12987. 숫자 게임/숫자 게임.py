from collections import deque
def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    q = deque(B)
    curA = A.pop()
    curB = q.pop()
    while True:
        if not A or not q:
            break
        if curB > curA:
            answer += 1
            curB = q.pop()
            curA = A.pop()
            continue
        if curB <= curA:
            q.popleft()
            curA = A.pop()
    if curB > curA:
        answer += 1
    return answer
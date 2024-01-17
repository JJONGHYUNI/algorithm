from collections import deque
def same(a, b):
    c = {}
    for i in b:
        if i not in a.keys():
            return False
        if i in c.keys():
            c[i] += 1
        else:
            c[i] = 1
        if c[i] > a[i]:
            return False
    return True
            
def solution(want, number, discount):
    answer = 0
    menu = {}
    dis = {}
    for i in range(len(want)):
        menu[want[i]] = number[i]
    
    q = deque([])
    
    for i in range(len(discount)):
        q.append(discount[i])
        if len(q) == 10:
            if same(menu, q):
                answer += 1
                q.popleft()
                continue
            q.popleft()
    return answer
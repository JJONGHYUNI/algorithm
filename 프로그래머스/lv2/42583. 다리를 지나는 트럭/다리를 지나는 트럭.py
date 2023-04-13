from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    truck=deque(truck_weights)
    Sum=0
    q=deque([0]*bridge_length)
    while q:
        answer+=1
        Sum-=q.popleft()
        if truck:
            if Sum+truck[0]<=weight:
                tmp=truck.popleft()
                Sum+=tmp
                q.append(tmp)
            else:
                q.append(0)
    return answer
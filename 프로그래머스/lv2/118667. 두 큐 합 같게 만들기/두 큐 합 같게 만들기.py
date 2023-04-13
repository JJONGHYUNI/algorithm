from collections import deque
def solution(queue1, queue2):
    answer = 0
    q1,q2=deque(queue1),deque(queue2)
    sum1,sum2=sum(q1),sum(q2)
    while True:
        if answer==300000:
            answer=-1
            break
        if sum1==sum2:
            break
        elif sum1>sum2:
            tmp=q1.popleft()
            q2.append(tmp)
            sum1-=tmp
            sum2+=tmp
        else:
            tmp=q2.popleft()
            q1.append(tmp)
            sum1+=tmp
            sum2-=tmp
        answer+=1
    return answer
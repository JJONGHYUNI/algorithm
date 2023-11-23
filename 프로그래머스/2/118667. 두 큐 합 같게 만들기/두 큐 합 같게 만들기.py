from collections import deque

def solution(queue1, queue2):
    answer = 0
    q1, q2 = deque(queue1), deque(queue2)
    sum1, sum2 = sum(queue1), sum(queue2)
    maxCycle = len(queue1) * 3
    if (sum1 + sum2) % 2 != 0 :
        return -1
    while True :
        if answer > maxCycle :
            return -1
        if sum1 == sum2 :
            return answer
        elif sum1 > sum2 :
            tmp = q1.popleft()
            q2.append(tmp)
            sum1 -= tmp
            sum2 += tmp
        else :
            tmp = q2.popleft()
            q1.append(tmp)
            sum1 += tmp
            sum2 -= tmp
        answer += 1
def solution(n):
    answer = 0
    start,end=0,0
    for i in range(1,n+1):
        sum=0
        sum+=i
        for j in range(i+1,n+1):
            sum+=j
            if sum>n:
                break
            elif sum==n:
                answer+=1
    return answer+1
def solution(n):
    answer = 0
    fibo=[]
    for i in range(n+1):
        if i<2:
            fibo.append(i)
        else:
            fibo.append(fibo[i-1]+fibo[i-2])
    answer=fibo.pop()%1234567
    return answer
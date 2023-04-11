def solution(s):
    answer = True
    #a,b는 '('갯수,')갯수'
    cnt,a,b=0,0,0
    for w in s:
        if w=='(':
            cnt+=1
            a+=1
        else:
            if cnt>0:
                cnt-=1
            b+=1
    if cnt!=0 or a!=b:
        answer=False
    return answer
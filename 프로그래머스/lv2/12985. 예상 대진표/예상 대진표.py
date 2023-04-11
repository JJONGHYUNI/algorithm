import math
def solution(n,a,b):
    answer = 0

    while n!=1:
        answer+=1
        if a%2==0 and a-1==b:
            break
        if b%2==0 and b-1==a:
            break
        a,b=math.ceil(a/2),math.ceil(b/2)
        n//=2
    return answer
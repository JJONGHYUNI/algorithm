def solution(n, t, m, p):
    answer = ''
    #첫번째 예제 0, 1 ,10, 11, 100, 110 ,111
    index=0
    trans=""
    for i in range(t*m):
        trans+=transform(i,n)
    while True:
        if len(answer)==t:
            break
        answer+=trans[m*index+p-1]
        index+=1
    return answer


def transform(num,q):
    temp='0123456789ABCDEF'
    transNum=""
    if num==0:
        return '0'
    while num>0:
        num, idx=num//q,num%q
        transNum+=temp[idx]
    return transNum[::-1]
#13번째 1 11의1 , 14:1 11의 1,15:1 12의 1, 16:2 12의 2
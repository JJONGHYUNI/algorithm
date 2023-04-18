from itertools import combinations
def solution(k, tangerine):
    answer = 0
    arr={}
    for i in tangerine:
        try:
            if arr[i]:
                arr[i]+=1
        except:
            arr[i]=1
    cnt=sorted(arr.values(),reverse=True)
    Sum=0
    for i in cnt:
        if Sum>=k:
            break
        answer+=1
        Sum+=i
    return answer
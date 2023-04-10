def solution(sequence, k):
    answer = []
    end=0
    res=99999999
    hap=0
    for start in range(len(sequence)):
        while hap<k and end<len(sequence):
            hap+=sequence[end]
            end+=1
        if hap==k and res>abs(start-end):
            res=abs(start-end)
            answer=[start,end-1]
        hap-=sequence[start]
    return answer
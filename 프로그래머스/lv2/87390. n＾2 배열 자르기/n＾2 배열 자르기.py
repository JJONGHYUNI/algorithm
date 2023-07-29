def solution(n, left, right):
    arr=[]
    for i in range(left,right+1):
        remain=i%n
        division=i//n
        tmp=max(remain,division)+1
        arr.append(tmp)
        
    return arr
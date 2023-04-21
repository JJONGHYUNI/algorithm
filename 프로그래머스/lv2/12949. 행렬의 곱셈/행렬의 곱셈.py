def solution(arr1, arr2):
    answer = []
    for i in arr1:
        tmp=[]
        for j in range (len(arr2[0])):
            cur=0
            for k in range(len(i)):
                cur+=i[k]*arr2[k][j]
            tmp.append(cur)
        answer.append(tmp)
                
    return answer
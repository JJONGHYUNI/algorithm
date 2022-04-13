#codeforce 1426
n=int(input())
array=list(map(int,input().split()))
sum=[0]*200000
map={}
answer=0
map[0]=1
#in map 은 key 값 조회
for i in range(n):
    sum[i]=array[i]
    if i!=0:
        sum[i]+=sum[i-1]
    if sum[i] in map:
        answer+=1
        map.clear()
        map[sum[i-1]]=1
    map[sum[i]]=1
print(answer)

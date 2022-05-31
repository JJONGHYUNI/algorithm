import sys
input=sys.stdin.readline

N,S=map(int,input().split())
array=list(map(int,input().split()))
some=[0]*(N+1)
for i in range(1,N+1):
    some[i]=some[i-1]+array[i-1]
start,end=0,0
answer=1000000
while start<N:
    if some[end]-some[start]>=S:
        answer=min(answer,end-start)
        start+=1
    else:
        if end<N:
            end+=1
        else:
            start+=1
if answer==1000000:
    print(0)
else:
    print(answer)

import sys
input=sys.stdin.readline

n,k=map(int,input().split())

values=[]
for _ in range(n):
    value=int(input())
    if value<=k:
        values.append(value)
    else:
        continue
index=len(values)-1
answer=0
while k:
    if k//values[index]!=0:
        answer+=k//values[index]
        k=k%values[index]
        index-=1
    else:
        index-=1

print(answer)

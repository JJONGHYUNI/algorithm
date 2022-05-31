import sys
from collections import deque
input=sys.stdin.readline
N,K=map(int,input().split())
current=[]
multi=list(map(int,input().split()))
answer=0
for i in range(K):
    if multi[i] in current:
        continue
    if len(current)<N:
        current.append(multi[i])
        continue
    temp=0
    far=0
    for tap in current:
        if tap not in multi[i:]:
            temp=tap
            break
        elif multi[i:].index(tap) > far:
            far=multi[i:].index(tap)
            temp=tap
    current[current.index(temp)]=multi[i]
    answer+=1
print(answer)
                    

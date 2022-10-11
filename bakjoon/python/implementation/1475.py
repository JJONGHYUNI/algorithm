import sys
import math

input=sys.stdin.readline
n=list(map(int,input().strip()))

cnt=[0]*10
sixNine=0
for i in range(len(n)):
    if n[i] not in [6,9]:
        cnt[n[i]]+=1
    else:
        sixNine+=1
maxIdx=cnt.index(max(cnt))
#올림 함수 ceil
sixNine=math.ceil(sixNine/2)
if cnt[maxIdx]>=sixNine:
    print(cnt[maxIdx])
else:
    print(sixNine)

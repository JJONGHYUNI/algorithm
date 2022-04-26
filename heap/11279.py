import sys
import heapq
input=sys.stdin.readline
N=int(input())
heap=[]
for _ in range(N):
    x=int(input())
    if x==0:
        if len(heap)==0:
            print(0)
        else:
            print(-1*heapq.heappop(heap))
    else:
        heapq.heappush(heap,-x)

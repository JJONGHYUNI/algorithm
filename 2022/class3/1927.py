import sys
import heapq
input=sys.stdin.readline

heap=[]
N=int(input())
for _ in range(N):
    command=int(input())
    if command==0:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap,command)

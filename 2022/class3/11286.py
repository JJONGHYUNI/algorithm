import sys
import heapq
input=sys.stdin.readline
heap=[]
N=int(input())
for _ in range(N):
    A=int(input())
    if A==0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
    else:
        heapq.heappush(heap,(abs(A),A))
    

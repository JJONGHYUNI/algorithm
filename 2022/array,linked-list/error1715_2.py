import sys
import heapq
input=sys.stdin.readline
heap=[]
n=int(input())
for _ in range(n):
    card=int(input())
    heapq.heappush(heap,card)
answer=0
i=0
k=0
while(len(heap)!=0):
    if(i>2):
        heapq.heappush(heap,k)
        k=heapq.heappop(heap)
        k=k+heapq.heappop(heap)
        answer=answer+k
    elif(i==2):
        k=answer
    else:
        answer=answer+heapq.heappop(heap)
    i+=1
print(answer)

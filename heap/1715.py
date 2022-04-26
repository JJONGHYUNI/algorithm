import sys
import heapq
input=sys.stdin.readline
heap=[]
n=int(input())
for _ in range(n):
    card=int(input())
    heapq.heappush(heap,card)
answer=0
k=0
while(len(heap)>1):
    k=heapq.heappop(heap)
    k=k+heapq.heappop(heap)
    heapq.heappush(heap,k)
    answer=answer+k
print(answer)

#처음 루프문 내용인데 왜 틀린지 모르겠다...
"""while(len(heap)!=0):
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
"""

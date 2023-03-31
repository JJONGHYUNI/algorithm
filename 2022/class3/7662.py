import sys
import heapq
input=sys.stdin.readline
T=int(input())
for _ in range(T):
    visited=[0]*1000001
    heapx,heapn=[],[]
    for i in range(int(input())):
        command=input().split()
        if command[0]=='I':
            heapq.heappush(heapn,(int(command[1]),i))
            heapq.heappush(heapx,(-int(command[1]),i))
            visited[i]=1
        else:
            if command[1]=='-1':
                while heapn and not visited[heapn[0][1]]:
                    heapq.heappop(heapn)
                if heapn:
                    visited[heapn[0][1]]=0
                    heapq.heappop(heapn)
            else:
                while heapx and not visited[heapx[0][1]]:
                    heapq.heappop(heapx)
                if heapx:
                    visited[heapx[0][1]]=0
                    heapq.heappop(heapx)
    while heapn and not visited[heapn[0][1]]:
        heapq.heappop(heapn)
    while heapx and not visited[heapx[0][1]]:
        heapq.heappop(heapx)
    if heapn:
        print(-heapx[0][0],heapn[0][0])
    else:
        print('EMPTY')

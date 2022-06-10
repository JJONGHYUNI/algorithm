import sys
from collections import deque
input=sys.stdin.readline
def bfs(idx):
    q=deque()
    visited[idx]=1
    q.append(idx)
    while q:
        cur=q.popleft()
        for i in arr[cur]:
            if not visited[i]:
                q.append(i)
                visited[i]=1
            else:
                continue
    return
    
N,M=map(int,input().split())
arr=[[]*(N+1) for _ in range(N+1)]
for _ in range(M):
    a,b=map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)
visited=[0]*(N+1)
answer=0
for i in range(1,N+1):
    if not visited[i]:
        bfs(i)
        answer+=1
print(answer)

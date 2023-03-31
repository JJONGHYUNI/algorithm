import sys
from collections import deque
input=sys.stdin.readline

N,K=map(int,input().split())
q=deque()
q.append((N,0))
visited=[0]*200001
def bfs():
    while q:
        cur,cnt=q.popleft()
        if cur == K:
            print(cnt)
            break
        visited[cur]=1
        if 0<=cur<=100000:
            if not visited[cur+1]:
                q.append((cur+1,cnt+1))
            if not visited[cur-1]:
                q.append((cur-1,cnt+1))
            if not visited[cur*2]:
                q.append((cur*2,cnt+1))
bfs()

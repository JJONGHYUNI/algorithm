import sys
from collections import deque
input=sys.stdin.readline

N,K=map(int,input().split())
def bfs():
    q=deque()
    visited=[0]*100001
    q.append((N,0))
    visited[N]=1
    while q:
        cur,t=q.popleft()
        if cur==K:
            print(t)
            return
        if 0<cur*2<100001 and not visited[cur*2]:
            q.appendleft((cur*2,t))
            visited[cur*2]=1
        if 0<=cur+1<100001 and not visited[cur+1]:
            q.append((cur+1,t+1))
            visited[cur+1]=1
        if 0<=cur-1<100001 and not visited[cur-1]:
            q.append((cur-1,t+1))
            visited[cur-1]=1

bfs()

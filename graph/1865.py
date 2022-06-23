import sys
from collections import deque
INF=sys.maxsize
input=sys.stdin.readline

T=int(input())
def bf(start):
    dis=[INF]*(N+1)
    dis[start]=0

    for i in range(N):
        for cur,goto,cost in road:
            if dis[goto]>cost+dis[cur]:
                dis[goto]=cost+dis[cur]
                if i==N-1:
                    return True
    return False
for _ in range(T):
    N,M,W=map(int,input().split())
    road=[]
    for _ in range(M):
        S,E,T=map(int,input().split())
        road.append((S,E,T))
        road.append((E,S,T))
    for _ in range(W):
        S,E,T=map(int,input().split())
        road.append((S,E,-T))
    if bf(1):
        print("YES")
    else:
        print("NO")

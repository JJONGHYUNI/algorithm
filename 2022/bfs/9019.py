import sys
from collections import deque
input=sys.stdin.readline
def bfs():
    q=deque()
    q.append((A,""))
    visited=[0]*10000
    while q:
        current,command=q.popleft()
        if current==B:
            print(command)
            break
        
        num=(current*2)%10000
        if visited[num]==0:
            q.append((num,command+'D'))
            visited[num]=1
                
        num=current-1
        if current==0 and visited[num]==0:
            num=9999
            q.append((num,command+'S'))
            visited[num]=1
            
        elif visited[num]==0:
            q.append((num,command+'S'))
            visited[num]=1
            
        num=(current%1000*10)+current//1000
        if visited[num]==0:
            q.append((num,command+'L'))
            visited[num]=1
            
        num=(current%10*1000)+current//10
        if visited[num]==0:
            q.append((num,command+'R'))
            visited[num]=1
        
t=int(input())
for _ in range(t):
    A,B=map(int,input().split())
    bfs()

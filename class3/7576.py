import sys
from collections import deque
input=sys.stdin.readline
q=deque()
d=[-1,1,0,0]
answer=0
def bfs():
    while q:
        y,x=q.popleft()
        for i in range(4):
            dx=x+d[i]
            dy=y+d[3-i]
            if 0<=dx<M and 0<=dy<N and board[dy][dx]==0:
                q.append((dy,dx))
                board[dy][dx]=board[y][x]+1

    find()
    
def find():
    global answer
    for i in board:
        for j in i:
            if j==0:
                answer=0
                return
            else:
                answer=max(answer,j)
                
M,N=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(N)]
for i in range(N):
    for j in range(M):
        if board[i][j]==1:
            q.append((i,j))
bfs()
print(answer-1)

import sys
from collections import deque
input=sys.stdin.readline
def bfs():
    while q:
        a,b,c=q.popleft()
        for i in range(6):
            x=a+dx[i]
            y=b+dy[i]
            z=c+dz[i]
            if 0<=x<H and 0<=y<N and 0<=z<M and board[x][y][z]==0:
                board[x][y][z]=board[a][b][c]+1
                q.append([x,y,z])
def find():
    global answer
    for i in board:
        for j in i:
            for k in j:
                if k==0:
                    print(-1)
                    exit()
                else:
                    answer=max(answer,k)
M,N,H=map(int,input().split())
board=[]
q=deque()
answer=0
for i in range(H):
    temp=[]
    for j in range(N):
        temp.append(list(map(int,input().split())))
        for k in range(M):
            if temp[j][k]==1:
                q.append([i,j,k])
    board.append(temp)

dx=[-1,1,0,0,0,0]
dy=[0,0,1,-1,0,0]
dz=[0,0,0,0,1,-1]
bfs()
find()
print(answer-1)

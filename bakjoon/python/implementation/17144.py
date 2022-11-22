import sys
import copy

input=sys.stdin.readline
d=[-1,1,0,0]
r,c,t=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(r)]
ans=0
#먼지 확산
def dust(y,x):
    temp=copyBoard[y][x]//5
    #4방향 확산
    for i in range(4):
        dy=y+d[i]
        dx=x+d[3-i]
        #벽이나 -1만나면 확산 x
        if 0<=dy<r and 0<=dx<c and board[dy][dx]>=0:
            board[dy][dx]+=temp
            board[y][x]-=temp
#위쪽 청정
def cleanTop(top):
    dy,dx=(0,-1,0,1),(1,0,-1,0)
    y,x,d=top,1,0
    previous = 0
    while True:
        ny,nx = y + dy[d], x + dx[d]
        #원래 위치로 오면 break
        if y == top and x==0:
            break
        #벽 끝을 만나면 반시계방향으로 돌림
        if not 0<=ny<r or not 0<=nx<c:
            d+=1
            continue
        #이전 board값을 옮김
        board[y][x],previous = previous,board[y][x]
        y,x=ny,nx
#아래쪽 청정
def cleanBottom(bottom):
    dy,dx=(0,1,0,-1),(1,0,-1,0)
    y,x,d=bottom,1,0
    previous=0
    while True:
        ny,nx = y + dy[d] , x + dx[d]

        if y== bottom and x==0:
            break
        if not 0<=ny<r or not 0<=nx<c:
            d+=1
            continue
        board[y][x],previous = previous,board[y][x]
        y,x=ny,nx

clean=[]

for _ in range(t):
    #동시확산에서 변화된 값에 영향을 받지 않기 위해 deepcopy로 복사
    copyBoard=copy.deepcopy(board)
    for i in range(r):
        for j in range(c):
            if copyBoard[i][j]>0:
                dust(i,j)
            #공기청정기 좌표
            if copyBoard[i][j]==-1 and len(clean)!=2:
                clean.append(i)
    cleanTop(clean[0])
    cleanBottom(clean[1])


for i in board:
    ans+=(sum(i))
print(ans+2)


import sys
from collections import deque
input = sys.stdin.readline

n=int(input())
d=[-1,1,0,0,]
board=[list(map(int,input().split())) for _ in range(n)]
y,x,size=0,0,2
for i in range(n):
    for j in range(n):
        if board[i][j]==9:
            y=i
            x=j
            board[i][j]=0

def bfs():
    q = deque([(y,x)])
    visited = [[0]*n for _ in range(n)]
    visited[y][x] = 0
    while q:
        curY,curX= q.popleft()
        for i in range(4):
            dy,dx=curY+d[i],curX+d[3-i]
            if 0<=dx<n and 0<=dy<n:
                if board[dy][dx]<=size and visited[dy][dx] ==0:
                    visited[dy][dx]=visited[curY][curX]+1
                    q.append([dy,dx])
    return visited

def fish(visited):
    global x,y
    mDist= 100000
    for i in range(n):
        for j in range(n):
            if visited[i][j]!=0 and 1<=board[i][j]<size:
                if visited[i][j] < mDist:
                    mDist=visited[i][j]
                    y,x=i,j
    if mDist==100000:
        return 0
    else:
        return y,x,mDist

ans = 0
food = 0

while True:
    result = fish(bfs())
    if not result:
        print(ans)
        break
    else:
        curY,curX = result[0],result[1]
        ans += result[2]
        board[curY][curX]=0
        food+=1

    if food >= size:
        size+=1
        food=0

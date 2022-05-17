import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())
board=[list(map(int,input().strip())) for _ in range(n)]
visited=[[[0]*2 for _ in range(m)]for _ in range(n)]

q=deque()
d=[-1,1,0,0]
#(x좌표,y좌표,벽 부심 여부)
q.append((0,0,0))
def bfs():
    while q:
        x,y,wall=q.popleft()
        if x==n-1 and y==m-1:
            return visited[x][y][wall]
        for i in range(4):
            dx=x+d[i]
            dy=y+d[3-i]
            if 0<=dx<n and 0<=dy<m:
                if board[dx][dy]==1 and wall==0:
                    visited[dx][dy][1]=visited[x][y][0]+1
                    q.append((dx,dy,wall+1))
                elif board[dx][dy]==0 and visited[dx][dy][wall]==0:
                    visited[dx][dy][wall]=visited[x][y][wall]+1
                    q.append((dx,dy,wall))
    return -1
visited[0][0][0]=1
print(bfs())

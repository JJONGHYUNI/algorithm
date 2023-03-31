import sys
from collections import deque

input=sys.stdin.readline

n,m=map(int,input().split())
d=[(-1,0),(0,-1),(1,0),(0,1)]
queue=deque()
queue.append((0,0))
miro=[list(map(int,input().strip())) for _ in range(n)]

def bfs():
    while queue:
        curX,curY=queue.popleft()
        for i in range(len(d)):
            dx=curX+d[i][0]
            dy=curY+d[i][1]
            if 0<=dx<n and 0<=dy<m:
                if miro[dx][dy]==1:
                    queue.append((dx,dy))
                    miro[dx][dy]=miro[curX][curY]+1
bfs()
print(miro[n-1][m-1])


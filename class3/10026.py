import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

d=[-1,1,0,0]
cnt=0
difCnt=0
def dfs(y,x,Type):
    visited[y][x]=1
    cur=board[y][x]
    for k in range(4):
        dy=y+d[k]
        dx=x+d[3-k]
        if 0<=dy<N and 0<=dx<N and visited[dy][dx]==0:
            if board[dy][dx]==cur and Type==0:
                dfs(dy,dx,0)
            elif Type==1:
                if (cur=='R' or cur=='G') and (board[dy][dx]=='R' or board[dy][dx]=='G'):
                    dfs(dy,dx,1)
                elif board[dy][dx]==cur:
                    dfs(dy,dx,1)
                    

N=int(input())
board=[list(input().strip()) for _ in range(N)]
visited=[[0]*N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(i,j,0)
            cnt+=1
visited=[[0]*N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(i,j,1)
            difCnt+=1
print(cnt,difCnt)

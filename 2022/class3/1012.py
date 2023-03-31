import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**5)
d=[1,-1,0,0]
def safty(y,x):
    if board[y][x]==0:
        return
    for idx in range(4):
        dy=y+d[idx]
        dx=x+d[3-idx]
        board[y][x]=0
        if 0<=dy<=N and 0<=dx<=M:
            safty(dy,dx)
    return
T=int(input())
for _ in range(T):
    count=0
    M,N,K=map(int,input().split())
    board=[[0]*(M+1) for _ in range(N+1)]
    for _ in range(K):
        x,y=map(int,input().split())
        board[y][x]=1
    for i in range(N):
        for j in range(M):
            if board[i][j]==1:
                safty(i,j)
                count+=1
    print(count)
                


import sys
input=sys.stdin.readline
N=int(input())
board=[list(map(int,input().split())) for _ in range(N)]
for k in range(N):
    for i in range(N):
        for j in range(N):
            if board[i][j] or (board[i][k] and board[k][j]) :
                board[i][j]=1

for i in board:
    for j in i:
        print(j,end=' ')
    print()

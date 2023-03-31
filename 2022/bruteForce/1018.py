import sys
import copy
input=sys.stdin.readline

n,m = map(int,input().split())
xIndex=0
yIndex=0

board=[list(input().strip()) for _ in range(n)]
countB=0
countW=0
answer=[]
while True:
    countB=0
    countW=0
    for i in range(yIndex,yIndex+8):
        for j in range(xIndex,xIndex+8):
            if (i+j)%2==0:
                if board[i][j]!='B':
                    countB+=1
                if board[i][j]!='W':
                    countW+=1
            else:
                if board[i][j]!='B':
                    countW+=1
                if board[i][j]!='W':
                    countB+=1
    answer.append(countB)
    answer.append(countW)
    if xIndex==m-8:
        xIndex=0
        yIndex+=1
    elif xIndex<m-8:
        xIndex+=1
    if yIndex>n-8:
        break
print(answer)
print(min(answer))

import sys
import copy
input=sys.stdin.readline

n,m=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(n)]
answerList=[]

def find_safty():
    global answerList
    current=copy.deepcopy(board)
    answer=0
    for i in range(n):
        for j in range(m):
            if current[i][j]==2:
                birus(i,j,current)
    for i in range(n):
        for j in range(m):
            if current[i][j]==0:
                answer+=1
    answerList.append(answer)
def birus(y,x,current):
    if(x+1<m and current[y][x+1]==0):
        current[y][x+1]=2
        birus(y,x+1,current)
    if(x-1>=0 and current[y][x-1]==0):
        current[y][x-1]=2
        birus(y,x-1,current)
    if(y+1<n and current[y+1][x]==0):
        current[y+1][x]=2
        birus(y+1,x,current)
    if(y-1>=0 and current[y-1][x]==0):
        current[y-1][x]=2
        birus(y-1,x,current)
def make_safty(index):
    if index==3:
        find_safty()
        return
    for i in range(n):
        for j in range(m):
            if board[i][j]==0:
                board[i][j]=1
                make_safty(index+1)
                board[i][j]=0
            else:
                continue
make_safty(0)
print(max(answerList))

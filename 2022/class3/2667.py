import sys
input=sys.stdin.readline
N=int(input())
board=[list(map(int,input().strip())) for _ in range(N)]
d=[1,-1,0,0]
count=0
houseCnt=0
answer=[]
def dfs(y,x):
    global count
    if x<0 or x>=N or y<0 or y>=N:
        return False
    if board[y][x]==1:
        count+=1
        board[y][x]=0
        for i in range(4):
            dy=y+d[i]
            dx=x+d[3-i]
            dfs(dy,dx)
        return True
    return False
def dfsPro():
    global count
    global houseCnt
    for i in range(N):
        for j in range(N):
            if dfs(i,j):
                answer.append(count)
                houseCnt+=1
                count=0
dfsPro()
answer.sort()
print(houseCnt)
print("\n".join(map(str,answer)))

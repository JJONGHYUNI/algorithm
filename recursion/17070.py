import sys
input=sys.stdin.readline

def pipe(x,y,shape):
    global answer

    if x==n-1 and y==n-1:
        answer+=1
        return

    if shape == 0 or shape == 2:
        if y+1 < n:
            if home[x][y+1]==0:
                pipe(x,y+1,0)
    if shape == 1 or shape == 2:
        if x+1<n:
            if home[x+1][y]==0:
                pipe(x+1,y,1)
    if x+1 < n and y+1 < n:
        if home[x+1][y]==0 and home[x][y+1]==0 and home[x+1][y+1]==0:
            pipe(x+1,y+1,2)
    

n=int(input())
home=[list(map(int,input().split())) for _ in range(n)]

answer=0
pipe(0,1,0)
print(answer)

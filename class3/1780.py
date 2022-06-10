import sys
input=sys.stdin.readline
zero,one,miOne=0,0,0
N=int(input())
board=[list(map(int,input().split())) for _ in range(N)]
def cut(y,x,n):
    global zero,one,miOne
    control=board[y][x]
    for i in range(y,y+n):
        for j in range(x,x+n):
            if control!=board[i][j]:
                control=10
                break
    if control == 10:
        n//=3
        for i in range(3):
            for j in range(3):
                cut(y+i*n,x+j*n,n)
    elif control==0:
        zero+=1
    elif control==1:
        one+=1
    else:
        miOne+=1
cut(0,0,N)
print(miOne)
print(zero)
print(one)

import sys
input=sys.stdin.readline

n=int(input())
image=[list(map(int,input().strip())) for _ in range(n)]

def quadTree(y,x,n):
    current=image[y][x]
    for i in range(y,y+n):
        for j in range(x,x+n):
            if current!=image[i][j]:
                print('(',end='')
                quadTree(y,x,n//2)
                quadTree(y,x+n//2,n//2)
                quadTree(y+n//2,x,n//2)
                quadTree(y+n//2,x+n//2,n//2)
                print(')',end='')
                return
    if current==0:
        print(0,end='')
        
    elif current==1:
        print(1,end='')
        
quadTree(0,0,n)

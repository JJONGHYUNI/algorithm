import sys
input= sys.stdin.readline

n=int(input())
image=[list(map(int,input().split())) for _ in range(n)]

white=0
blue=0
def ColorPaper(y,x,n):
    global white
    global blue
    current=image[y][x]
    for i in range(y,y+n):
        for j in range(x,x+n):
            if current!=image[i][j]:
                ColorPaper(y,x,n//2)
                ColorPaper(y,x+n//2,n//2)
                ColorPaper(y+n//2,x,n//2)
                ColorPaper(y+n//2,x+n//2,n//2)
                return
    if current==0:
        white+=1
        
    else:
        blue+=1
        

ColorPaper(0,0,n)
print(white)
print(blue)
        

import sys
input=sys.stdin.readline

n,m=map(int,input().split())
image=[list(map(int,input().split())) for _ in range(n)]
#만들어지는 모든 모양
tetromino=[
    [(0, 0), (0, 1), (1, 0), (1, 1)],
    [(0, 0), (0, 1), (0, 2), (0, 3)],
    [(0, 0), (1, 0), (2, 0), (3, 0)],
    [(0, 0), (0, 1), (0, 2), (1, 0)],
    [(1, 0), (1, 1), (1, 2), (0, 2)],
    [(0, 0), (1, 0), (1, 1), (1, 2)],
    [(0, 0), (0, 1), (0, 2), (1, 2)],
    [(0, 0), (1, 0), (2, 0), (2, 1)],
    [(2, 0), (2, 1), (1, 1), (0, 1)],
    [(0, 0), (0, 1), (1, 0), (2, 0)],
    [(0, 0), (0, 1), (1, 1), (2, 1)],
    [(0, 0), (0, 1), (0, 2), (1, 1)],
    [(1, 0), (1, 1), (1, 2), (0, 1)],
    [(0, 0), (1, 0), (2, 0), (1, 1)],
    [(1, 0), (0, 1), (1, 1), (2, 1)],
    [(1, 0), (2, 0), (0, 1), (1, 1)],
    [(0, 0), (1, 0), (1, 1), (2, 1)],
    [(1, 0), (0, 1), (1, 1), (0, 2)],
    [(0, 0), (0, 1), (1, 1), (1, 2)]
]
answer=[]
def maxTetro(x,y):
    global answer
    for i in range(len(tetromino)):
        cal=0
        for j in range(len(tetromino[i])):
            try:
                xPos=x+tetromino[i][j][0]
                yPos=y+tetromino[i][j][1]
                cal+=image[xPos][yPos]
            except IndexError: #indexerror날경우 break
                break
        answer.append(cal)

for i in range(n):
    for j in range(m):
        maxTetro(i,j)
print(max(answer))

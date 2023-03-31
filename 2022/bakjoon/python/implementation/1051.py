import sys
input=sys.stdin.readline

n,m=map(int,input().split())
board=[list(map(int,input().strip())) for _ in range(n)]
ans=[]

for i in range(n):
    for j in range(m):
        temp=board[i][j]
        #x축 둘러보기
        for k in range(j,m):
            #같은게 있다면 y축으로도 같은 길이의 범위가 되는지 확인
            if temp==board[i][k] and i+k-j<n:
                #각 꼭짓점이 temp값과 같은지 확인
                if temp==board[i+k-j][j] and temp==board[i+k-j][k]:
                    ans.append(k-j+1)
print(max(ans)**2)

import sys
input=sys.stdin.readline

n=int(input())

#도화지
board=[[0]*101 for _ in range(101)]

#색종이로 도화지 채우기 (겹쳐도 차지한 범위는 그대로이므로 지나간 부분 모두 1로)
for _ in range(n):
    w,h= map(int,input().split())
    for i in range(w,w+10):
        for j in range(h,h+10):
            board[i][j]=1

ans=0

#도화지 칠해진 부분 세기
for i in board:
    for j in i:
        ans+=j
print(ans)

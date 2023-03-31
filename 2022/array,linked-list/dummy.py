#3190
import sys
from collections import deque
n=int(input())
k=int(input())
board=[[0]*n for _ in range(n)]
apple=[list(map(int,input().split())) for _ in range(k)]
for i in range(k):
    board[apple[i][0]-1][apple[i][1]-1]=1
l=int(input())
times={}
for i in range(l):
    t,d=input().split()
    times[int(t)]=d
time=1
sneakLength=1
dx=[0,1,-1]
dy=[0,1,-1]
x=0
y=0
dxindex=1
dyindex=0
board[y][x]=2
sneak=deque([[y,x]])
while True:
    x=x+dx[dxindex]
    y=y+dy[dyindex]
    if 0<=x<n and 0<=y<n and board[y][x]!=2:
        if board[y][x]==1:
            sneakLength+=1
        sneak.append([y,x])
        board[y][x]=2
        if time in times.keys():
            if times[time]=='L':
                if dxindex==0 and dyindex==1:
                    dxindex=1
                    dyindex=0
                elif dxindex==0 and dyindex==2:
                    dxindex=2
                    dyindex=0
                elif dxindex==1 and dyindex==0:
                    dyindex=2
                    dxindex=0
                elif dxindex==2 and dyindex==0:
                    dxindex=0
                    dyindex=1
            elif times[time]=='D':
                if dxindex==0 and dyindex==1:
                    dxindex=2
                    dyindex=0
                elif dxindex==0 and dyindex==2:
                    dxindex=1
                    dyindex=0
                elif dxindex==1 and dyindex==0:
                    dyindex=1
                    dxindex=0
                elif dxindex==2 and dyindex==0:
                    dxindex=0
                    dyindex=2
        while len(sneak)>sneakLength:
            dely,delx=sneak.popleft()
            board[dely][delx]=0
        time+=1
    else:
        break
print(time)
    

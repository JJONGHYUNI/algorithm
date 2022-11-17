import sys

#deque의 rotate함수로 쉽게 회전하기 위해 import
from collections import deque
input=sys.stdin.readline

#왼쪽 부분 회전
def left_rotate(idx,d):
    #같은 극이거나 왼쪽 범위를 초과할 경우 return
    if idx<0 or command[idx]==0:
        return
    wheel[idx].rotate(-d)
    left_rotate(idx-1,-d)
    
def right_rotate(idx,d):
    #같은극이거나 오른쪽 범위를 초과할 경우 return
    if idx>3 or command[idx-1]==0:
        return
    wheel[idx].rotate(-d)
    right_rotate(idx+1,-d)

#현재 마주하는 극의 상태를 저장
def is_rotate():
    command.clear()
    if wheel[0][2]!=wheel[1][6]:
        command.append(1)
    else:
        command.append(0)
    if wheel[1][2]!=wheel[2][6]:
        command.append(1)
    else:
        command.append(0)
    if wheel[2][2]!=wheel[3][6]:
        command.append(1)
    else:
        command.append(0)

#deque를 담을 wheel 선언
wheel={}
for i in range(4):
    wheel[i]=deque(list(map(int,input().strip())))
    
k=int(input())

command=[]

for _ in range(k):
    a,b=map(int,input().split())
    is_rotate()
    left_rotate(a-2,b)
    right_rotate(a,b)
    #자기자신도 회전
    wheel[a-1].rotate(b)
ans=0
temp=0

#12시방향에 따라서 점수 올림 (2의 n승)
for i in range(4):
    if wheel[i][0]==1:
       ans+=2**temp
    temp+=1
    
print(ans)

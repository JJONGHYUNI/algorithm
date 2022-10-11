import sys
from collections import deque

input=sys.stdin.readline
t=int(input())

for _ in range(t):
    n,idx=map(int,input().split())
    q=deque(list(map(int,input().split())))
    cnt=0
    
    #idx가 0보다 작아지면 찾는 수가 pop된 것
    while idx>=0:
        maxQ=max(q)
        cur=q.popleft()
        #맥스 값과 현재 값이 같으면 가장 큰수가 하나 빠져나온것
        if maxQ==cur:
            cnt+=1
            idx-=1
        else:
            #가장 큰수가 아닐경우에는 꺼낸 값을 맨뒤로 이동.
            q.append(cur)
            #뒤로 보내야될 수가 찾는 수였으면 꺼내지는 순서인 idx를 맨 뒤로 수정
            if idx==0:
                idx=len(q)-1
            else:
                idx-=1

    print(cnt)

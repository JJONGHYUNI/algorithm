import sys
from collections import deque
input=sys.stdin.readline

n,k=map(int,input().split())
q=deque([i for i in range(1,n+1)])
ans=[]
#q가 빌때까지 반
while q:
    #k-1개지워서 뒤에 붙이기
    for i in range(k-1):
        q.append(q[0])
        q.popleft()
    #k번째 수 ans에 넣기
    ans.append(q.popleft())
print('<'+", ".join(map(str,ans))+'>')

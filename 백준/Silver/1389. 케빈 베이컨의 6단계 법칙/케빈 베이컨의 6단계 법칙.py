import sys
from collections import deque
input=sys.stdin.readline
def cabin(bd,start):
    q=deque()
    visit=[0] * 101
    visited=[0]*101
    q.append(start)
    visited[start]=1
    while q:
        cur=q.popleft()
        for i in board[cur]:
            if not visited[i]:
                q.append(i)
                visited[i]=1
                visit[i]=visit[cur]+1
            else:
                continue
    return sum(visit)
N,M=map(int,input().split())
board=[[] for _ in range(N+1)]
for i in range(M):
    a,b=map(int,input().split())
    board[a].append(b)
    board[b].append(a)
answer=[]
for i in range(1,N+1):
    answer.append(cabin(board,i))
answerIdx=answer.index(min(answer))
print(answerIdx+1)
import sys
input=sys.stdin.readline
N=int(input())
M=int(input())
tree=list([]*(N+1) for _ in range(N+1))
for _ in range(M):
    a,b=map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)
visited=[0]*101
visited[1]=1
answer=0
def dfs(start):
    global answer
    visited[start]=1
    for i in tree[start]:
        if not visited[i]:
            dfs(i)
            answer+=1
dfs(1)
print(answer)

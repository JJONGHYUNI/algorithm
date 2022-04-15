#9372
import sys
input=sys.stdin.readline
T=int(input())
def find(index,answer):
    visit[index]=1
    for i in Tree[index]:
        if visit[i]==0:
            answer=find(i,answer+1)
    return answer
for _ in range(T):
    n,m=map(int,input().split())
    Tree=[[] for _ in range(n+1)]
    for i in range(m):
        a,b=map(int,input().split())
        Tree[a].append(b)
        Tree[b].append(a)
    visit=[0]*(n+1)
    result=find(1,0)
    print(result)

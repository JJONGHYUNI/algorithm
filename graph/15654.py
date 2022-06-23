import sys
input=sys.stdin.readline

N,M=map(int,input().split())
arr=sorted(list(map(int,input().split())))
answer=[]
def dfs():
    if len(answer)==M:
        print(' '.join(map(str,answer)))
        return
    for i in range(N):
        if arr[i] not in answer:
            answer.append(arr[i])
            dfs()
            answer.pop()
dfs()

import sys
input=sys.stdin.readline

n,m=map(int,input().split())
answer=[]
def backTraking(index):
    if index==m:
        for i in range(m):
            if answer[i] in answer[i+1:] or answer[i] in answer[0:i]:
                return
        print(' '.join(map(str,answer)))
        return
    for i in range(1,n+1):
        answer.append(i)
        backTraking(index+1)
        answer.pop()
backTraking(0)

import sys
input=sys.stdin.readline

n,m=map(int,input().split())
answer=[]
def backTraking(index):
    if index == m:
        print(' '.join(map(str,answer)))
        return
    for i in range(1,n+1):
        answer.append(i)
        backTraking(index+1)
        answer.pop()

backTraking(0)

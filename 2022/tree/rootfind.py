#11725번
import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
n=int(input())

Tree = [[] for _ in range(n+1)]
Answer=[0 for _ in range(n+1)]
for i in range(n-1):
    num,num2=map(int,input().split())
    Tree[num].append(num2)
    Tree[num2].append(num)

def find(tree,start,answer):
    for i in tree[start]:
        if answer[i]==0:
            answer[i]=start
            find(tree, i ,answer)

find(Tree,1,Answer)

for i in range(2,n+1):
    print(Answer[i])

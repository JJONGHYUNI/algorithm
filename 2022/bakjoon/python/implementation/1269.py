import sys
input=sys.stdin.readline

a,b=map(int,input().split())
listA=set(list(map(int,input().split())))
listB=set(list(map(int,input().split())))

ans1=listA.difference(listB)
ans2=listB.difference(listA)
print(len(ans1)+len(ans2))

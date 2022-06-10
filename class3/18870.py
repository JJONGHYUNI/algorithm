import sys
input=sys.stdin.readline
N=int(input())
arr=list(map(int,input().split()))
arr2=sorted(set(arr))
answer={}
for i in range(len(arr2)):
    answer[arr2[i]]=i
for i in arr:
    print(answer[i],end=' ')

import sys
input= sys.stdin.readline
n,k=map(int,input().split())
numList=list(map(int,input().split()))
numList.sort()
print(numList[k-1])

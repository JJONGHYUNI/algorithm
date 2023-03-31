import sys
from collections import deque
input=sys.stdin.readline
prime_list=[]
isPrime=[True]*(10001)
def prime(n):
    for i in range(2,n+1):
        if isPrime[i] == True:
            for j in range(2*i,n+1,i):
                isPrime[j] = False
def bfs(start,end):
    q.append((start,0))
    visited=[0]*10000
    visited[start]=1
    while q:
        current,count=q.popleft()
        if current==end:
            return count
        current=str(current)
        for i in range(4):
            for j in range(10):
                temp= int(current[:i]+str(j)+current[i+1:])
                if visited[temp]==0 and isPrime[temp] and temp>=1000:
                    visited[temp]=1
                    q.append([temp,count+1])
    return -1
prime(10000)
T=int(input())
for _ in range(T):
    q=deque()
    A,B=map(int,input().split())
    print(bfs(A,B))

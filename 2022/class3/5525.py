import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)

N=int(input())
M=int(input())
S=input().rstrip()
cnt,cur,idx=0,0,0
while idx<M-2:
    if S[idx:idx+3]=="IOI":
        cur+=1
        if cur==N:
            cnt+=1
            cur-=1
        idx+=2
    else:
        idx+=1
        cur=0
print(cnt)

import sys
input=sys.stdin.readline
dp=[0]*51
dp[0]=1
dp[1]=1
for i in range(2,51):
    dp[i]=dp[i-1]+dp[i-2]

T=int(input())
for _ in range(T):
    n=int(input())
    if n==0:
        print(1,0)
    elif n==1:
        print(0,1)
    else:
        print(dp[n-2],dp[n-1])

import sys
input=sys.stdin.readline
dp=[1]*101
dp[0],dp[4]=0,2
for i in range(5,101):
    dp[i]=dp[i-1]+dp[i-5]
T=int(input())
for _ in range(T):
    n=int(input())
    print(dp[n])

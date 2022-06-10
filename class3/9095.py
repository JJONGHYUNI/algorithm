import sys
input=sys.stdin.readline
dp=[1]*300
dp[2]=dp[0]+dp[1]
for i in range(3,11):
    dp[i]=dp[i-3]+dp[i-2]+dp[i-1]
T=int(input())
for _ in range(T):
    n=int(input())
    print(dp[n])

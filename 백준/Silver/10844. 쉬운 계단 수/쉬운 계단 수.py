#start 15:33
#end   16:15

import sys
input = sys.stdin.readline

n = int(input())

dp = [[0] * 10 for _ in range(n+1)]
MOD = 1000000000
for i in range(1, 10):
    dp[1][i] = 1

for i in range(2, n+1):
    for j in range(10):
        if j == 0:
            dp[i][j] = dp[i-1][j+1]
            continue
        if j == 9:
            dp[i][j] = dp[i-1][j-1]
            continue
        dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
print(sum(dp[n]) % MOD)
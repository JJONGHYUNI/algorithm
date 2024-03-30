#start 14:00
#end   14:45

import sys
input = sys.stdin.readline

n = int(input())

dp = [i for i in range(n+1)]

for i in range(4, n + 1):
    root = int(i **(1/2))
    for j in range(2, root + 1):
        dp[i] = min(dp[i], dp[i - j * j] + 1);

print(dp[n])

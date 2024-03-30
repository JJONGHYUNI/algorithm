#start 18:43
#end   19:27

import sys
from collections import deque

input = sys.stdin.readline

n, m, k = map(int, input().split())

dp = [[1] * m for _ in range(n)]
cnt = 0
ky, kx = 0, 0
if k != 0:
    for i in range(n):
        for j in range(m):
           cnt += 1
           if cnt == k:
               ky, kx = i, j
               break
        if ky:
            break
    for i in range(ky):
        for j in range(kx + 1, m):
            dp[i][j] = 0
    for i in range(kx):
        for j in range(ky + 1, n):
            dp[j][i] = 0
for i in range(1, n):
    for j in range(1, m):
        if not dp[i][j]:
            continue
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
print(dp[n-1][m-1])

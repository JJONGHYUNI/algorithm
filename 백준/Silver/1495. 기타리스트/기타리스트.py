# start 14:25
# end   15:00
import sys
from collections import deque
input = sys.stdin.readline

n, s, m = map(int, input().split())
v = list(map(int, input().split()))

dp = [[0] * (m + 1) for _ in range(n + 1)]
dp[0][s] = 1
for i in range(0, n):
    for j in range(m+1):
        if dp[i][j]:
            tmp = j + v[i]
            tmp2 = j - v[i]
            if 0 <= tmp <= m:
                dp[i+1][tmp] = 1
            if 0 <= tmp2 <= m:
                dp[i+1][tmp2] = 1
answer = -1
for i in range(m, -1, -1):
    if dp[n][i]:
        answer = i
        break
print(answer)
# start 13:20
# end   13:35
import sys

input = sys.stdin.readline
n = int(input())
dp = [1] * (n + 1)
dp[1] = 3
for i in range(2, n + 1):
    dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901

print(dp[n])
"""
1. 1 + 2 = 3
2. 1 + 4 + 2 = 7
3. 1 + 6 + 8 + 2 = 17
4. 1 + 8 + 18 + 12 + 2 = 41
"""

import sys

input = sys.stdin.readline
answer = 0
n = list(map(int,input().strip()))
l = len(n)
dp = [0] * (l+1)
dp[0] = 1

if n[0] == 0:
    print(0)
    exit()

for i in range(1, l):
    two = n[i-1] * 10 + n[i]
    if n[i] > 0:
        dp[i] += dp[i-1]
    if two <= 26 and two >= 10 and i >= 2:
        dp[i] += dp[i-2]
    if two <= 26 and two >= 10 and i == 1:
        dp[i] += 1
print(dp[l-1] % 1000000)

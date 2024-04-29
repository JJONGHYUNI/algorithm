import sys
input = sys.stdin.readline
LEN = 123456 * 2

primeList = [1] * (LEN + 1)
primeList[0], primeList[1] = 0, 0
def makePrime():
    for i in range(2, int(LEN ** (1/2))):
        if primeList[i]:
            for j in range(i * i, LEN + 1, i):
                primeList[j] = 0

makePrime()

dp = [0] * (LEN + 1)

for i in range(2, LEN + 1):
    if primeList[i]:
        dp[i] += 1
    dp[i] += dp[i-1]

while True:
    n = int(input())
    if n == 0:
        break

    print(dp[2 * n] - dp[n])
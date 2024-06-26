import sys
input = sys.stdin.readline

n = int(input())

dp = [[0] * (3) for _ in range(n + 1)]
MOD = 1_000_000_007

# 각 자릿수의 합이 3으로 나누어 떨어지고, 끝자리가 5
# 1, 5로만 이루어지면 나올 수 있는 나머지는 0, 1, 2 이다
# 따라서 맨 뒷자리는 5로 고정하고 dp[1][2] = 1 , 5의 나머지 값이 2이므로
dp[1][2] = 1
for i in range(2, n + 1):
    #나머지가 1인거에 5를 추가하면 15로 나떨, 2인거는 1을 추가하면 나떨
    dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD
    #나머지가 0인거에 1을 추가하면 1, 2인거에서 5추가하면 1
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD
    #나머지가 0인거에 5 추가 , 나머지가 1인거에 1추가할시 나머지가 2
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD

print(dp[n][0])

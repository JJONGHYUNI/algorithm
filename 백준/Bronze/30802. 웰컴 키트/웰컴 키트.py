import sys

input = sys.stdin.readline

n = int(input())
ts = list(map(int, input().split()))
t, p = map(int, input().split())

ansT = 0
for tmp in ts:
    ansT += (int) (tmp / t);
    if tmp % t != 0:
        ansT += 1

print(ansT)
print((int)(n / p), (int) (n % p))

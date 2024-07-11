import sys
input = sys.stdin.readline

n = int(input())
cnt = 0
nn = n
while True:
    a = nn // 10
    b = nn % 10
    c = (a + b) % 10
    nn = (b * 10) + c
    cnt += 1
    if (n == nn):
        break
print(cnt)

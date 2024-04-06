# start 14:34
# end   15:18

import sys
input = sys.stdin.readline

n, h = map(int, input().split())

d = [0] * (h + 1)
u = [0] * (h + 1)

for i in range(n):
    tmp = int(input())
    if i % 2 == 0:
        d[tmp] += 1
        continue
    u[tmp] += 1

for i in range(h - 1, 0, -1):
    d[i] += d[i+1]
    u[i] += u[i+1]
cnt = n
ran = 0

for i in range(1, h+1):
    tmp = d[i] + u[h - i + 1]
    if cnt > tmp:
        cnt = tmp
        ran = 1
    elif cnt == tmp:
        ran += 1
print(cnt, ran)
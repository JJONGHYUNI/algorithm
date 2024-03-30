#start 18:43
#end   19:09

import sys
from collections import deque

input = sys.stdin.readline

n, m, k = map(int, input().split())

board = [[0] * m for _ in range(n)]
cnt = 0
ky, kx = 0, 0
q = deque()
c = 1
if k != 0:
    c = 0
    for i in range(n):
        for j in range(m):
           cnt += 1
           if cnt == k:
               ky, kx = i, j
               break
        if ky:
            break
q.append((0, 0, c))
d = [0, 1]
answer = 0
while q:
    y, x, tmp = q.popleft()
    if y == n - 1 and x == m - 1 and tmp == 1:
        answer += 1
        continue
    if k != 0 and not tmp and (y > ky or x > kx):
        continue
    for i in range(2):
        dy = y + d[i]
        dx = x + d[1-i]
        if dy < n and dx < m:
            if (dy == ky and dx == kx):
                q.append((dy,dx,tmp+1))
            q.append((dy,dx,tmp))

print(answer)

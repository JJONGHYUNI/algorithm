#start 18:28
#end   18:53

import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
answer = []
a = list(map(int, input().split()))
Len = len(a)
q= deque()
q.append((0,0))
visited = [0] * (Len + 101)
visited[0] = 1
while q:
    x, jump = q.popleft()
    if x >= Len - 1:
        print(jump)
        exit()
    for i in range(1, a[x] + 1):
        dx = x + i
        if visited[dx]:
            continue
        q.append((dx, jump + 1))
        visited[dx] = 1
print(-1)
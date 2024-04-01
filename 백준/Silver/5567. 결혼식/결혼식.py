# start 19:38
# end   19:58

import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
answer = 0

board = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    board[a].append(b)
    board[b].append(a)

visited = [0] * (n+1)
q = deque()
visited[1] = 1
q.append((1, 0))
while q:
    a, b = q.popleft()
    if b >= 2:
        continue
    for i in board[a]:
        if not visited[i]:
            visited[i] = 1
            answer += 1
            q.append((i, b + 1))
print(answer)

# start 16:56
# end   17:23
import sys
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())
board = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
def bfs(s):
    q = deque([s])
    visited[s] = 1
    cnt = 1
    while q:
        tmp = q.popleft()
        board[tmp].sort()
        for i in board[tmp]:
            if not visited[i]:
                cnt += 1
                visited[i] = cnt
                q.append(i)
    
for _ in range(m):
    a, b = map(int, input().split())
    board[a].append(b)
    board[b].append(a)
visited[r] = 1
bfs(r)

for i in visited[1:]:
    print(i)
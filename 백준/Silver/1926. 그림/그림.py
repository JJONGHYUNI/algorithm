# start 18:55
# end   19:17

import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
answer = 0
d = [0, 0, -1, 1]
visited = [[0] * m for _ in range(n)]
def dfs(y, x):
    global tmp
    
    visited[y][x] = 1
    tmp += 1
    
    for i in range(4):
        dy = y + d[i]
        dx = x + d[3 - i]
        if 0 <= dy < n and 0 <= dx < m and not visited[dy][dx] and board[dy][dx]:
            dfs(dy, dx)

            
cnt = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j] and board[i][j]:
            tmp = 0
            cnt += 1
            dfs(i, j)
            answer = max(tmp, answer)
print(cnt)
print(answer)

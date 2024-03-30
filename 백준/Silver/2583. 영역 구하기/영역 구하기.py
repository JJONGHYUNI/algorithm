#start 14:50
#end   15:20

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

m, n, k = map(int, input().split())
board = [[0] * n for _ in range(m)]
visited = [[0] * n for _ in range(m)]

for _ in range(k):
    x, y, dx, dy = map(int, input().split())
    for i in range(y, dy):
        for j in range(x, dx):
            board[i][j] = 1
d = [0, 0, -1, 1]
def dfs(y, x):
    global cnt
    cnt += 1
    for i in range(4):
        dy = y + d[i]
        dx = x + d[3-i]
        if 0 <= dy < m and 0 <= dx < n:
            if not visited[dy][dx] and not board[dy][dx]:
                visited[dy][dx] = 1
                board[dy][dx] = 1
                dfs(dy, dx)
                
answer = []
for i in range(m):
    for j in range(n):
        if not board[i][j] and not visited[i][j]:
            board[i][j] = 1
            visited[i][j] = 1
            cnt = 0
            dfs(i, j)
            answer.append(cnt)
print(len(answer))
answer.sort()
print(" ".join(map(str, answer)))
            

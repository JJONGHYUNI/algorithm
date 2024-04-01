# start 16:02
# end   16:19
import sys
sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

r, c = map(int, input().split())

board = [list(input().strip()) for _ in range(r)]
d = [0, 0, -1, 1]
visited = [[0] * c for _ in range(r)]
sheep, wolf = 0, 0
def dfs(y, x):
    global sheep, wolf
    visited[y][x] = 1

    if board[y][x] == 'o':
        sheep += 1
    elif board[y][x] == 'v':
        wolf += 1
    
    for i in range(4):
        dy = y + d[i]
        dx = x + d[3 - i]
        if 0 <= dy < r and 0 <= dx < c and not visited[dy][dx] and board[dy][dx] != '#':
            dfs(dy, dx)
ansS, ansW = 0, 0
for i in range(r):
    for j in range(c):
        sheep, wolf = 0, 0
        if not visited[i][j] and board[i][j] != '#':
            dfs(i, j)
        if sheep > wolf:
            ansS += sheep
            continue
        ansW += wolf
print(ansS, ansW)
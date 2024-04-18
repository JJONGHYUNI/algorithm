import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

r, c = map(int, input().split())
d = [-1, 1, 0, 0]
wolf, sheep = 0, 0
board = [list(input().strip()) for _ in range(r)]
w, s = 0, 0
visited = [[0] * c for _ in range(r)]

def dfs(y, x):
    global wolf, sheep
    visited[y][x] = 1

    for i in range(4):
        dy = y + d[i]
        dx = x + d[3 - i]
        if 0 <= dy < r and 0 <= dx < c and not visited[dy][dx] and board[dy][dx] != '#':
            if board[dy][dx] == 'v':
                wolf += 1
            elif board[dy][dx] == 'o':
                sheep += 1
            dfs(dy, dx)

for i in range(r):
    for j in range(c):
        if board[i][j] != '#' and not visited[i][j]:
            sheep, wolf = 0, 0
            if board[i][j] == 'v':
                wolf += 1
            elif board[i][j] == 'o':
                sheep += 1
            dfs(i, j)
            if sheep > wolf:
                s += sheep
                continue
            w += wolf
print(s, w)
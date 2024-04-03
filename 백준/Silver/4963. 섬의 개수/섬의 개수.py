# start 12:56
# end   13:22

import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(y, x):
    for i in range(4):
        dy = y + d[i]
        dx = x + d[3 - i]
        if 0 <= dy < h and 0 <= dx < w and board[dy][dx]:
            board[dy][dx] = 0
            dfs(dy, dx)
    for i in range(4):
        dy = y + dd[i][0]
        dx = x + dd[i][1]
        if 0 <= dy < h and 0 <= dx < w and board[dy][dx]:
            board[dy][dx] = 0
            dfs(dy, dx)

d = [0, 0, -1, 1]
dd = [(-1, -1), (-1, 1), (1, -1), (1, 1)]

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    board = [list(map(int, input().split())) for _ in range(h)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if board[i][j]:
                board[i][j] = 0
                dfs(i, j)
                cnt +=1
    print(cnt)
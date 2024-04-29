import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]
d = [-1, 1, 0, 0]
visited = [[0] * m for _ in range(n)]
answer = 0

def dfs(y, x):
    global answer
    visited[y][x] = 1
    for i in range(4):
        dy = y + d[i]
        dx = x + d[3 - i]
        if 0 <= dx < m and 0 <= dy < n and not visited[dy][dx]:
                if board[dy][dx] == 'O':
                    dfs(dy, dx)
                elif board[dy][dx] == 'P':
                    answer += 1
                    dfs(dy, dx)
                continue

for i in range(n):
    for j in range(m):
        if board[i][j] == 'I':
            dfs(i, j)
            if answer == 0:
                print('TT')
                exit()
            print(answer)
            exit()
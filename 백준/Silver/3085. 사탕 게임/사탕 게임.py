import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n = int(input())
board = [list(input().strip()) for _ in range(n)]
d = [0, 1]
answer = 0

def change(y, x):
    tmp = board[y][x]
    for i in range(2):
        dy = y + d[i]
        dx = x + d[1 - i]
        if dy < n and dx < n:
            cur = board[dy][dx]
            if tmp == cur:
                continue
            board[dy][dx] = tmp
            board[y][x] = cur
            find()
            board[dy][dx] = cur
            board[y][x] = tmp

def find():
    global answer
    for i in range(n):
        cnt = 1
        for k in range(n - 1):
            if board[i][k] == board[i][k + 1]:
                cnt += 1
            else:
                cnt = 1
            answer = max(cnt, answer)
        cnt = 1
        for k in range(n - 1):
            if board[k][i] == board[k + 1][i]:
                cnt += 1
            else:
                cnt = 1
            answer = max(answer, cnt)

for i in range(n):
    for j in range(n):
        change(i, j)
print(answer)
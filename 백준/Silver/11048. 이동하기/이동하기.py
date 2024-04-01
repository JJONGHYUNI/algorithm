# start 14:40
# end   14:57
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    board[i][0] += board[i-1][0]
for i in range(1, m):
    board[0][i] += board[0][i-1]

for i in range(1, n):
    for j in range(1, m):
        board[i][j] += max(board[i-1][j], board[i-1][j-1], board[i][j-1])
print(board[n-1][m-1])

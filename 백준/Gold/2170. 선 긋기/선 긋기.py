# start 12:26
# end   12:51

import sys
input = sys.stdin.readline

n = int(input())
answer = 0
board = []
for _ in range(n):
    a, b = map(int, input().split())
    if a > b:
        board.append((b, a))
        continue
    board.append((a,b))
board.sort()
x, y = board[0]
for i in range(1, n):
    dx, dy = board[i]
    if dx > y:
        answer += (y - x)
        x = dx
        y = dy
        continue
    if dy > y:
        y = dy
answer += (y - x)
print(answer)

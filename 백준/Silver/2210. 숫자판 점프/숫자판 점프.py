#start 18:03
#end   18:18

import sys
input = sys.stdin.readline

board = list(list(map(int, input().split())) for _ in range(5))
answer = []
d = [0, 0, -1, 1]
def dfs(y, x, target):
    if len(target) == 6:
        if target not in answer:
            answer.append(target)
        return
    for i in range(4):
        dy = y + d[i]
        dx = x + d[3-i]

        if 0 <= dy < 5 and 0 <= dx < 5:
            dfs(dy, dx, target + str(board[dy][dx]))

for i in range(5):
    for j in range(5):
        dfs(i, j, str(board[i][j]))
print(len(answer))

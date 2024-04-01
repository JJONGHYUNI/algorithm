# start 15:08
# end   15:45
import sys

input = sys.stdin.readline

n, d, k, c = map(int, input().split())

board = []
for _ in range(n):
    board.append(int(input()))

answer = []
cnt = 0
control = 0
for i in range(n - k + 1):
    tmp = board[i:i+k]
    l = len(set(tmp))
    if cnt < l:
        answer = []
        answer.append(tmp)
        cnt = l
        if c in tmp:
            control = 0
        else:
            control = 1
    elif cnt == l and c not in tmp:
        control = 1
for i in range(n - k + 1, n):
    tmp = board[i:n] + board[0:k-(n-i)]
    l = len(set(tmp))
    if cnt < l:
        answer = []
        answer.append(tmp)
        cnt = l
        if c in tmp:
            control = 0
        else:
            control = 1
    elif cnt == l and c not in tmp:
        control = 1
if control:
    print(cnt+1)
else:
    print(cnt)

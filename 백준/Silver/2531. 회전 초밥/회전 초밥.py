# start 15:08
# end   15:55
import sys

input = sys.stdin.readline

n, d, k, c = map(int, input().split())

board = []
for _ in range(n):
    board.append(int(input()))

answer = 0

for i in range(n - k + 1):
    tmp = board[i:i+k]
    l = len(set(tmp))
    if answer > l:
        continue
    if c not in tmp:
        l += 1
    answer = max(answer, l)
for i in range(n - k + 1, n):
    tmp = board[i:n] + board[0:k-(n-i)]
    l = len(set(tmp))
    if answer > l:
        continue
    if c not in tmp:
        l += 1
    answer = max(answer, l)

print(answer)
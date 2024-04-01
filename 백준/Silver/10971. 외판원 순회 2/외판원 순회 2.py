# start 18:01
# end   18:52
import sys
input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
MIN = sys.maxsize

def dfs(start, target, cost, visited):
    global MIN

    if len(visited) == n:
        if board[target][start] != 0:
            MIN = min(MIN, cost + board[target][start])
        return

    for i in range(n):
        tmp = 0
        if board[target][i]:
            tmp = cost + board[target][i]
        if tmp and i not in visited and tmp < MIN:
            visited.append(i)
            dfs(start, i, tmp, visited)
            visited.pop()

for i in range(n):
    dfs(i, i, 0, [i])
print(MIN)

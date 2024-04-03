# start 10:30
# end   12:00

import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
def bfs():
    q = deque()
    q.append((preX, preY))
    visited = [0] * n
    control = 0
    while q:
        x, y = q.popleft()
        if abs(targetX - x) + abs(targetY - y) <= 1000:
            print("happy")
            control = 1
            break
        for i in range(n):
            if not visited[i]:
                if abs(board[i][0] - x) + abs(board[i][1] - y) <= 1000:
                    visited[i] = 1
                    q.append((board[i][0], board[i][1]))
    if not control:
        print("sad")
for _ in range(t):
    n = int(input())
    board = [[] for _ in range(n)]
    preX, preY = map(int,input().split())
    for i in range(n):
        a, b = map(int, input().split())
        board[i].append(a)
        board[i].append(b)
    targetX, targetY = map(int, input().split())
    bfs()
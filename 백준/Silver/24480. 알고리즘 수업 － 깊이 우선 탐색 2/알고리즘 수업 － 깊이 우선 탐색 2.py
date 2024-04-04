# start 15:08
# end   15:41
import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(s):
    global cnt
    board[s].sort(reverse = True)
    visited[s] = cnt
    for i in board[s]:
        if not visited[i]:
            cnt += 1
            dfs(i)
n, m, r = map(int, input().split())
board = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, input().split())
    board[a].append(b)
    board[b].append(a)
cnt = 1
dfs(r)
for i in range(1, n + 1):
    print(visited[i])
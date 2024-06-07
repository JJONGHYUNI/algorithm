import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, r, q = map(int, input().split())
tree = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(n - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

query = list(int(input()) for _ in range(q))

def dfs(cur):
    global visited
    visited[cur] = 1

    for nxt in tree[cur]:
        if not visited[nxt]:
            visited[cur] += dfs(nxt)

    return visited[cur]
dfs(r)

for i in query:
    print(visited[i])

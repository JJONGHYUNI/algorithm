import sys
input = sys.stdin.readline

n, m = map(int, input().split())

a, b = [], []

for r in range(n):
    r = list(map(int, input().split()))
    a.append(r)

for r in range(n):
    r = list(map(int, input().split()))
    b.append(r)

for r in range(n):
    for c in range(m):
        print(a[r][c] + b[r][c], end = ' ')
    print()
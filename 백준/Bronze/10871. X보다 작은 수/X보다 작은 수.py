import sys
input = sys.stdin.readline

n, x = map(int, input().split())
arr = list(map(int, input().split()))

for a in arr:
    if a < x:
        print(a, end = " ")
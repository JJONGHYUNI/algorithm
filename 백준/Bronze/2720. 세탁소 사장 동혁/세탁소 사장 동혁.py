import sys
input = sys.stdin.readline

arr = [25, 10, 5, 1]

t = int(input())

for _ in range(t):
    c = int(input())
    for i in arr:
        print(c // i, end = ' ')
        c %= i
    print()
import sys
input = sys.stdin.readline

b = [int(input()) for _ in range(3)]
d = [int(input()) for _ in range(2)]
print(min(b) + min(d) - 50)